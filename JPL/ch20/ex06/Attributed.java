package ch20.ex06;
/***
  1.�ǂ��l�����ǂ����Fgeneric�ɂ���K�v�͂Ȃ��BAttr�������v�f�͖{��Attr�ŉB�������ׂ��Ȃ̂ɁA�K�v�ȏ��generic�̌^��Attr�������C���^�[�t�F�[�X��R���N�V�����N���X�ɒm�点�Ă��܂����߁B
  2.�C���^�[�t�F�[�X�ւ̉e���FAttributed�C���^�[�t�F�[�X��generic�^�ɂȂ�Ȃ���Eclipse����x����������Ă��܂��BAttributed�C���^�[�t�F�[�X��Attr�Ɋi�[�����v�f�̌^��m��K�v���Ȃ����߁Ageneric�^�͗ǂ��Ȃ��Ǝv����B
  3.Attributed�ɑ΂��Ă̈Ӗ��FAttributed�I�u�W�F�N�g��Attr�Ɋi�[�����v�f�̌^��m��K�v���Ȃ����߈Ӗ��͂Ȃ��B
**/
public interface Attributed<E> {
	void add(Attr<E> newAttr);
}
