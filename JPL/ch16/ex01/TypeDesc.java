package ch16.ex01;
import java.lang.reflect.*;

public class TypeDesc {
	public static void main(String[] args) {
		TypeDesc desc = new TypeDesc();
		for (String name : args) {
			try {
				Class<?> startClass = Class.forName(name);
				desc.printType(startClass, 0, basic);
			} catch (ClassNotFoundException e) {
				System.err.println(e); // report the error
			}
		}
	}
	
	// �f�t�H���g�ŕW���o�͂ɕ\������
	private java.io.PrintStream out = System.out;
	
	// �^���Ƀ��x���t������printType()�Ŏg�p�����
	private static String[]
			basic = {"class", "interface", "enum", "annotation"},
			supercl = {"extends", "implements"},
			iFace = {null, "extends"};
	
	private void printType(Type type, int depth, String[] labels) {
		if (type == null) // �ċA�Ăяo����~�F�X�[�p�[�^�C�v�����݂��Ȃ�
			return;
		
		// Type��Class�I�u�W�F�N�g�ɕϊ�����
		Class<?> cls = null;
		if (type instanceof Class<?>)
			cls = (Class<?>) type;
		else if (type instanceof ParameterizedType)
			cls = (Class<?>)((ParameterizedType)type).getRawType();
		else
			throw new Error("Unexpected non-class type");
		
		// Type�̌^��Object�^�ł���ꍇ��return
		if (cls.equals(Object.class))
			return;
		
		// ���̌^��\��
		for (int i = 0; i < depth; i++)
			out.print(" ");
		int kind = cls.isAnnotation() ? 3 :
			cls.isEnum() ? 2 :
			cls.isInterface() ? 1 : 0;
		out.print(labels[kind] + " ");
		out.print(cls.getCanonicalName());
		
		// ����΁A�W�F�l���b�N�^�p�����[�^��\��
		TypeVariable<?>[] params = cls.getTypeParameters();
		if (params.length > 0) {
			out.print('<');
			for (TypeVariable<?> param : params) {
				out.print(param.getName());
				out.print(", ");
			}
			out.println("\b\b>");
		}
		else
			out.println();
		
		// ���̃N���X���������Ă���S�ẴC���^�t�F�[�X��\��
		Type[] interfaces = cls.getGenericInterfaces();
		for (Type iface : interfaces) {
			printType(iface, depth + 1, cls.isInterface() ? iFace : supercl);
		}
		// �X�[�p�[�N���X�ɑ΂��čċA
		printType(cls.getGenericSuperclass(), depth + 1, supercl);
	}
}
