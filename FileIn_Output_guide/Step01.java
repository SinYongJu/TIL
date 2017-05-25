package FileIn_Output_guide;

public class Step01 {
  public static void main(String[] args) {
    File f = new File("../html01");

     System.out.printf("getAbsolutePath()=%s\n",f.getAbsolutePath());

     System.out.printf("getCanonicalPath()=%s\n",f.getCanonicalPath());

     System.out.printf("getFreeSpace()=%d\n",f.getFreeSpace() );

     System.out.printf("getTotalSpace()=%d\n",f.getTotalSpace() );

     System.out.printf("getUsableSpace()=%d\n",f.getUsableSpace() );


     System.out.printf("getName()=%s\n",f.getName());
     System.out.printf("getPath()=%s\n",f.getPath());
     System.out.printf("getPath()=%s\n",f.exists());

     System.out.printf("isDirectory()=%s\n",f.isDirectory());
     System.out.printf("isFile()=%b\n",f.isFile());
     System.out.printf("length()=%d\n",f.length());
     System.out.printf("lastModified()=%d\n",f.lastModified());



     File f = new File("../");

    String[] files = f.list();

    for ( String name : files){
      System.out.println(name);
    }

    File[] files = f.listFiles();

    for ( File file : files){
      System.out.printf("%s %12d %s\n", (file.isDirectory() ? "d" : '-'),
          file.length(),
          file.getName()
          );
    }


    //재귀 함수의 사용!



    File f = new File("../");




     displayDirectory(f, 0);


     public static void displayDirectory(File dir, int level){
         File[] files = dir.listFiles();    // 경로의 읽어온 파일들을 배열로 만들어 버림!

         for ( File file : files){
           for (int i = 0; i < level; i++)System.out.println("     ");

             System.out.printf("%s  %s\n",
                 (file.isDirectory() ? ">" : ' '),
                 file.getName());//printf
          if (file.isDirectory()){
            displayDirectory(file, level+1);
          }

         }// 1 for

  }

  public static void displayDirectory(File dir, int level) throws Exception{
     File[] files = dir.listFiles(new MyFileFilter());     //익명 클래스의 사용!!
    //  경로의 pathname들을 읽어서 배열로 만들어요!  그리고 인터페이스로써 accept와 같이 쓰여요!
    //그래서 아래에 반복문을 돌리는 이유에요

     //목록에서 특정 확장자를 가진 파일을 걸러내어 처리한다. 그러나 목록의 개수 만큼 반복문을 돌려야 한다.
     for ( File file : files){
       if (file.isDirectory()){
         displayDirectory(file, level+1);
       }else {
         System.out.printf(" %s\n", file.getCanonicalPath());
     }

   }
  }
   static class MyFileFilter implements FileFilter{

     @Override
     public boolean accept(File file) {
       if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))){
         return true;
       }
       // TODO Auto-generated method stub
       return false;
     }

    }//class
// FileFilter라는 인터페이스를 사용하여 MyFileFilter에  FileFilter라는 클래스의 accept()메소드를
// 를 Override하였다.!



public static void displayDirectory(File dir, int level) throws Exception{
  File[] files = dir.listFiles((File file) -> {  //람다라는 표기법을! 쓴거야!
        if (file.isDirectory() || (file.isFile() && file.getName().endsWith(".class"))){
          return true;
        }    //디렉토리 거나 , 파일이고 끝이 .class 로 끝나?
        // TODO Auto-generated method stub
        return false;
      });
// if의 조건들이 해당 되면 return true

    //목록에서 특정 확장자를 가진 파일을 걸러내어 처리한다. 그러나 목록의 개수 만큼 반복문을 돌려야 한다.
    for ( File file : files){
      if (file.isDirectory()){
        displayDirectory(file, level+1);
      }else {
        System.out.printf(" %s\n", file.getCanonicalPath());
    }
  }


}

/*
file이라는 class는 1개씩 읽어온다 생각하고 전체를 알고 싶다면 배열화 해서 써야 한다는 걸
기억 하자 사용법!

하나만 읽어 올꺼면 file이라는 클래스로 초기화!

여러개면
초기화한 객체에 static method인 fileList()를


그리고 FileFilter라는 클래스(interface)를 사용하여 파일을 거른다.! 특히
이 예제에서처럼 FileFilter라는 오버라이딩하는데는 accept라는 메소드를 오버라이딩 할것!
*/

헛갈린다.
 FileInputStream  요놈이 !!입력!!시켜 화면에서 보기위해서 !!출력할때 read()
  FileOutputStream  요놈이 !!출력!!시켜 !!입력할때   write()
기본적으로 이 클래스의  read와 write는 1바이트씩 주고 읽는다는걸 기억 하자!

Stream에서의 최상위 가장 소단위의 기능을 가진 이 객체는 무조건 1바이트씩이라
비트연산을 요구한다. 예제 추후에....

또한 1바이트이기에 기본적으로 이 클래스가 다루는 타입이 byte이다.

그래서 array의 방식과 object의 방식으로 읽어 오는 class들이 서브로 존재함 (아직 따로 큰 3대장들은 안올림)

올리거나 읽을때는 항상 배열화로 읽고 쓰임

읽을때도 반복문 ㅋㅋㅋㅋ 그러나 재귀로 끝까지 읽을것!



buffered는 특정 크기의 배열로 쌓아서 만들어 저장(cache 참고)하고 양만큼만 읽고
배출함

단! 쓰일때 특정 byte배열 크기 까지만 저장하고 내놓으므로 flush()라는 메소드를 끝에
꼬옥꼬옥 써주어야 합니다!


그래야 남은 애들 전부다 나와요!


decorator는 accept를 이용한다! 상속과 달리 수퍼클레스는 다르나 필요한 기능만!
인헤릿은 필요없어도 기능을 받아들인다.


/*
Socket에 관하여! 소켓은 서버와 클라이언트에서 이용되는 클래스를 말한다.

 ServerSocket serverSocket = new ServerSocket(8888); 야가 서버
 Socket socket = new Socket("localhost",8888); 야가 클라


 항상 in/output stream이용시 .close()로 닫기!

 sccaner와 printclass 에 대하여!








*/




}
