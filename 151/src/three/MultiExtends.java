package three;

/**
 *   使用内部类 实现多继承
 * @author Chain
 *
 */
public class MultiExtends {
	public static void main(String[] args) {
		Elk el = new Elk();
		System.out.println(el.likeDeer());
		System.out.println(el.likeHorse());
		System.out.println(el.likeDonkey());
		System.out.println(el.likeCattle());
	}
}

class Elk extends DeerImpl implements Horse,Cattle,Donkey{


	@Override
	public int likeDeer() {
		return super.likeDeer() + 1;
	}
	
	@Override
	public int likeHorse() {
		return new HorseSpecial().likeHorse();
	}
	
	private class HorseSpecial extends HorseImpl{
		public int likeHorse() {
			return super.likeHorse() + 1;
		}
	}

	@Override
	public int likeCattle() {
		return new CattleSpecial().likeCattle();
	}
	
	private class CattleSpecial extends CattleImpl{
		public int likeCattle() {
			return super.likeCattle() + 2;
		}
	}

	@Override
	public int likeDonkey() {
		// TODO Auto-generated method stub
		return new DonkeySpecial().likeDonkey();
	}
	
	private class DonkeySpecial extends DonkeyImpl{
		public int likeDonkey() {
			return super.likeDonkey() + 20;
		}
	}
}


interface Deer{//鹿
	int likeDeer();
}
interface Horse{//马
	int likeHorse();
}
interface Cattle{//牛
	int likeCattle();
}
interface Donkey{//驴
	int likeDonkey();
}


class DeerImpl implements Deer{
	@Override
	public int likeDeer() {
		System.out.println("like  deer .");
		return 0;
	}
}
class HorseImpl implements Horse{
	@Override
	public int likeHorse() {
		System.out.println("like  horse .");
		return 0;
	}
}
class CattleImpl implements Cattle{
	@Override
	public int likeCattle() {
		System.out.println("like  cattle .");
		return 0;
	}
}
class DonkeyImpl implements Donkey{
	@Override
	public int likeDonkey() {
		System.out.println("like  donkey .");
		return 0;
	}
}