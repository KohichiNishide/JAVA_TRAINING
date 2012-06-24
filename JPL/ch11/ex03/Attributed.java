package ch11.ex03;
/***
  1.良い考えかどうか：genericにする必要はない。Attrが扱う要素は本来Attrで隠蔽されるべきなのに、必要以上にgenericの型をAttrを扱うインターフェースやコレクションクラスに知らせてしまうため。
  2.インターフェースへの影響：Attributedインターフェースもgeneric型にならないとEclipseから警告をもらってしまう。AttributedインターフェースはAttrに格納される要素の型を知る必要がないため、generic型は良くないと思われる。
  3.Attributedに対しての意味：AttributedオブジェクトもAttrに格納される要素の型を知る必要がないため意味はない。
**/
public interface Attributed<E> {
	void add(Attr<E> newAttr);
}
