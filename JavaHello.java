
/*�޼ҵ� ȣ�⿡ ���� ���α׷�*/

class MethodInvoke{
	// aMethod()ȣ�� �޽����� ���
static void aMethod(){
	
System.out.println("aMethod() �� ȣ��ȴ�. ");	
}
// bMethod()ȣ�� �޽����� ����� aMethod()ȣ��
static void bMethod(){
System.out.println("bMethod()�� ȣ��ȴ�.");
aMethod();
}

public static void main(String[] args){
// aMethod()ȣ��
aMethod();
// bMethod()ȣ��
bMethod();
}

}