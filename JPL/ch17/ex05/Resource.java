package ch17.ex05;

interface Resource {
	void use(Object key, Object... args);
	void release();
}
