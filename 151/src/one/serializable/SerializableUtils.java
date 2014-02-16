package one.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableUtils {
	private final static String FILE_NAME = "c:/object.bin";

	public static void writeObject(Serializable s) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(FILE_NAME));
			oos.writeObject(s);
			oos.close();
		} catch (FileNotFoundException e) {
			System.out.println("(" + FILE_NAME + ") 未找到。");
		} catch (IOException e) {
			System.out.println("文件输入输出流异常。");
		}
	}

	public static Object readObject(){
		Object obj = null;
		try {
			ObjectInput ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
			obj = ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			System.out.println("file not found !!");
		} catch (IOException e) {
			System.out.println("io exception!!");
		} catch (ClassNotFoundException e) {
			System.out.println("class not found ..");
		}
		return obj;
	}
}
