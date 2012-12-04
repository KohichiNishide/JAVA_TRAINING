package ch17.ex05;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


public final class ResourceManager {
	final ReferenceQueue<Object> queue;
	final Map<Reference<?>, Resource> refs;
	boolean shutdown = false;
	
	public ResourceManager() {
		queue = new ReferenceQueue<Object>();
		refs = new HashMap<Reference<?>, Resource>();
	}
	
	public void shutdown() {
		if (!shutdown) {
			System.out.println("ShutDown...");
			shutdown = true;
			checkQueue(); //刈り取りスレッドの代替メソッド
		}
	}
	
	public Resource getResource(Object key) {
		if (shutdown)
			throw new IllegalStateException();
		
		checkQueue(); //刈り取りスレッドの代替メソッド
		
		Resource res = new ResourceImpl(key);
		Reference<?> ref = new PhantomReference<Object>(key, queue);
	
		refs.put(ref, res);
		return res;
	}
	
	// 刈り取りスレッドの代替メソッド
	private void checkQueue() {
		System.out.println("Start checking queue...");
		Reference<?> ref;
		while ((ref = queue.poll()) != null) {
		    System.out.println("ref is enqueued.");
		    Resource res = null;
		    res = refs.get(ref);
			refs.remove(ref);
			res.release();
			ref.clear();
		}
		System.out.println("End checking queue...");
	}
	
	/////////////////////////////////////////////////////////
	//            Internal : ResourceImpl
	////////////////////////////////////////////////////////
	private static class ResourceImpl implements Resource {
		WeakReference<Object> ref;
		boolean needsRelease = false;
		
		ResourceImpl(Object key) {
			ref = new WeakReference<Object>(key);
			needsRelease = true;
		}
		
		public void use(Object key, Object... args) {
			System.out.println("use.");
		}
		
		public synchronized void release() {
			if (needsRelease) {
				needsRelease = false;
				ref.clear();
				Runtime.getRuntime().gc();
				System.out.println("release. key:" + ref.get());
			}			
		}
	}
}
