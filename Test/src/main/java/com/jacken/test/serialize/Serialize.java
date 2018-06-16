package com.jacken.test.serialize;

import com.alibaba.fastjson.JSON;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jacken
 * @date 2018/04/20
 */
public class Serialize {

  public static void main(String[] args) {
    try (FileOutputStream fileOutputStream = new FileOutputStream(
        new File("/Users/Shared/json.txt"))) {
      Person person = new Person();
      person.setAge(11);
      person.setName("test");
      fileOutputStream.write(JSON.toJSONBytes(person));
      fileOutputStream.flush();
      fileOutputStream.close();

      FileInputStream fileInputStream = new FileInputStream(new File("/Users/Shared/json.txt"));
//      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      byte[] bytes = new byte[1024*1024];
      fileInputStream.read(bytes);
      Person deserializePerson =  JSON.parseObject(bytes, Person.class);
//      Person deserializePerson = (Person) objectInputStream.readObject();
      System.out.println(JSON.toJSONString(deserializePerson));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
