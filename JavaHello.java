
/*메소드 호출에 대한 프로그램*/

class MethodInvoke{
	// aMethod()호출 메시지를 출력
static void aMethod(){
	
System.out.println("aMethod() 가 호출된다. ");	
}
// bMethod()호출 메시지를 출력후 aMethod()호출
static void bMethod(){
System.out.println("bMethod()가 호출된다.");
aMethod();
}

public static void main(String[] args){
// aMethod()호출
aMethod();
// bMethod()호출
bMethod();
}

}