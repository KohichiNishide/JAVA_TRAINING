package ch17.ex04;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;


public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	final Thread reaper;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
		reaper = new ReaperThread();
		reaper.start();
		
		// ... リソースの初期化 ...
	}
	
	public synchronized void shutdown() {
		if (!shutdown) {
			System.out.println("ShutDown...");
			shutdown = true;
			//reaper.interrupt(); //interruptしない
		}
	}
	
	public synchronized Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
	
		refs.put(ref, res);
		return res;
	}
	
	private static <T> void message(Reference<? extends T> ref, ReferenceQueue<T> queue, String prefix){
        if(ref == null){
            System.out.println(prefix + ":" + "Reference was null");
        } else {
            String c = ref.getClass().getSimpleName();
            System.out.println(prefix + ":" + c + ".isEnqueued: " + ref.isEnqueued());
            System.out.println(prefix + ":" + c + ".get: " + ref.get());
        }
        if(queue != null){
            Reference<? extends T> r = queue.poll();
            System.out.println(prefix + ":" + "queue.poll: " + r);
            message(r, null, "<nest:" + prefix + ">");
        }
        System.out.println();
    }
	
	class ReaperThread extends Thread {
		public void run() {
			// refsが空になるまで実行
			while (true) {
				Reference<?> ref;
				try {
					ref = queue.remove();
					System.out.println("ref != null");
					Resource res = null;
					synchronized(ResourceManager.this) {
						res = refs.get(ref);
						refs.remove(ref);
					}
					res.release();
					ref.clear();
				} catch (InterruptedException e) {
					System.out.println("interrupted");
					break;
				}
				
				// refsが空になるまでチェックを続ける
				if (shutdown && refs.isEmpty()) {
					System.out.println("isEmpty");
					break;
				}
			}
			System.out.println("Thread is stopped");
		}
	}
	
	private static class ResourceImpl implements Resource {
		int KeyHash;
		boolean needsRelease = false;
		
		ResourceImpl(Object key) {
			KeyHash = System.identityHashCode(key);
			
			// .. 外部リソースの設定
			needsRelease = true;
		}
		
		public void use(Object key, Object... args) {
			if (System.identityHashCode(key) != KeyHash)
				throw new IllegalArgumentException("wrong key");
			
			// ... リソースの使用 ...
		}
		
		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;
				
				// ..リソースの解放 ...
				
			}			
		}
	}
}
