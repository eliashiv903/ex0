

import java.util.ArrayList;

public class ComplexFunction implements complex_function{
	private ArrayList<function> functions;
	private ArrayList<Operation> operations;
	
	public  ComplexFunction(String s) {
		
		operations=new ArrayList<Operation>();
		 functions= new ArrayList<function>();
		String t="";
		String c=s;
		int sumOperation=0;
		for (int i = s.length()-1; i >=0; i--) {
			while(s.charAt(i)==')') {
				sumOperation++;
				s=s.substring(0, i);
				i--;
			}
			int n=0;
			System.out.println(s);
			//if(s.charAt(i)<='a' && s.charAt(i)>='z')throw new RuntimeException("ERR the  op not good , got: "+s);
			//if(s.charAt(i)' ||(s.charAt(i)<='0' && s.charAt(i)>='9')||(s.charAt(i)=='-' || s.charAt(i)>='+')) {
			if(s.charAt(i)==',' || s.charAt(i)=='(') {
				if((s.charAt(i+1)>='0' && s.charAt(i+1)<='9')||s.charAt(i+1)=='-' || s.charAt(i+1)=='+'){
				t=s.substring(i+1, s.length());
				functions.add(new Polynom(t));
				s=s.substring(0, i);
				i=s.length();
				n++;
			}
				else if(s.charAt(i+1)>='a' && s.charAt(i+1)<='z') {
					t=s.substring(i+1, s.length());
					operations.add(setOperation(t));
					s=s.substring(0, i);
					i=s.length();
					n++;
				}
				else throw new RuntimeException("ERR the  kelet no good , got: "+c);
			}
		}
		if(sumOperation>0)operations.add(setOperation(s));
		else functions.add(new Polynom(s));
	}
	public  ComplexFunction(ComplexFunction p) {
		operations=new ArrayList<Operation>();
		 functions= new ArrayList<function>();
		for (int i = 0; i < p.functions.size(); i++) functions.add(p.functions.get(i));
		for (int i = 0; i < p.operations.size(); i++) operations.add(p.operations.get(i));
	}
	public  ComplexFunction() {
		 operations=new ArrayList<Operation>();
		 functions= new ArrayList<function>();
		 Monom a=new Monom(0,2);
		 functions.add(a);
		 
	}
public  ComplexFunction(function a) {
	 operations=new ArrayList<Operation>();
	 functions= new ArrayList<function>();
	//function v=a.initFromString(a.toString());
	functions.add(a);
	
	
	
	 
}
public  ComplexFunction(String s ,function  a,function b) {//׳׳©׳ ׳•׳× ׳׳¡׳˜׳¨׳™׳ ׳’
	 operations=new ArrayList<Operation>();
	 Operation c=setOperation(s);
	 operations.add(c);
	 if(c.equals(Operation.None))throw new RuntimeException("ERR the  Monom should  be wife power afrer x or empty , got: "+s);
	 functions= new ArrayList<function>();
	// function v=a.initFromString(a.toString());
	 //function v1=b.initFromString(b.toString());//
	 
	 functions.add(a);
	 functions.add(b);
}
public static  Operation setOperation(String s) {
	Operation c;
	if(s.equals("plus"))c=Operation.Plus;
	else if(s.equals("mul"))c=Operation.Times;
	else if(s.equals("max"))c=Operation.Max;
	else if(s.equals("div"))c=Operation.Divid;
	else if(s.equals("min"))c=Operation.Min;
	else if(s.equals("comp"))c=Operation.Comp;
	//else if(s.equals("none"))c=Operation.None;
	else throw new RuntimeException("ERR the  op not good , got: "+s);
	return c;
}

	@Override
	public double f(double x) {	
		double sum=0;
		sum+=functions.get(0).f(x);
		for (int i = 1,j=0; i < functions.size(); i++,j++) {
			if(operations.size()==j)break;
			if(operations.get(j)==Operation.Plus)sum+=functions.get(i).f(x);
			if(operations.get(j)==Operation.Divid)sum/=functions.get(i).f(x);
			if(operations.get(j)==Operation.Times)sum*=functions.get(i).f(x);
			if(operations.get(j)==Operation.Max) if(sum<functions.get(i).f(x))sum=functions.get(i).f(x);
			if(operations.get(j)==Operation.Min) if(sum>functions.get(i).f(x))sum=functions.get(i).f(x);
			
		}
		return sum;
		
		}
	public int sizeFunctions() {
		return  functions.size();
	}

	@Override
	public function initFromString(String s) {
		//ComplexFunction a= new ComplexFunction();
		//String t="";
		//String c=s;
		//int sumOperation=0;
		//for (int i = s.length()-1; i >=0; i--) {
		//	while(s.charAt(i)==')') {
				//sumOperation++;
				//s=s.substring(0, i);
				//i--;
			//}
			//int n=0;
			//System.out.println(s);
			//if(s.charAt(i)<='a' && s.charAt(i)>='z')throw new RuntimeException("ERR the  op not good , got: "+s);
			//if(s.charAt(i)' ||(s.charAt(i)<='0' && s.charAt(i)>='9')||(s.charAt(i)=='-' || s.charAt(i)>='+')) {
			//if(s.charAt(i)==',' || s.charAt(i)=='(') {
				//if((s.charAt(i+1)>='0' && s.charAt(i+1)<='9')||s.charAt(i+1)=='-' || s.charAt(i+1)=='+'){
				//t=s.substring(i+1, s.length());
				//a.functions.add(new Polynom(t));
				//s=s.substring(0, i);
				//System.out.println(i);
				//i=s.length();
				//n++;
		//	}
				//else if(s.charAt(i+1)>='a' && s.charAt(i+1)<='z') {
					//t=s.substring(i+1, s.length());
					//a.operations.add(setOperation(t));
					//s=s.substring(0, i);
					//System.out.println(i);
					//i=s.length();
					//n++;
				//}
				//else throw new RuntimeException("ERR the  kelet no good , got: "+c);
			//}
			//System.out.println(s);
			//if(n==3)throw new RuntimeException("ERR the  op not goodvvvvvvv , got: "+s);
			
		//	if(s.charAt(i)==',') {
				
				
				
			//	s.substring(i+1, s.length());
			//}
			//if(s.charAt(i)=='(') {
			//	t=s.substring(0, i);
			//	operations.add(setOperation(t));
			//	s.substring(i, s.length());
			//	i=-1;
		//	}
			//if(i!=-1) {
			//if(s.charAt(i)>='a' && s.charAt(i)<='z');
			//else if(s.charAt(i)=='-' || s.charAt(i)>='+' || s.charAt(i)>='0' && s.charAt(i)<='9')	;
			//}
	//	}
		//a.operations.add(setOperation(s));
		//System.out.println(s);
	
		return new ComplexFunction(s);
	}

	@Override
	public function copy() {
		ComplexFunction a=new ComplexFunction(this);
		return a;
	}
	public boolean equals(Object obj) {
		if(this.toString().equals(obj.toString()))return true;
		return false;
	}
	public String toString() {
		
		String a="";
		boolean q=true;
		String b="";
		for (int i = 0,j=0,k=0,l=0; i <functions.size(); i++,j++,q=true) {
			if(j<operations.size()) {
				if(operations.get(j)==Operation.Plus)a+="plus"+"(";;
				if(operations.get(j)==Operation.Divid)a+="div"+"(";;
				if(operations.get(j)==Operation.Times)a+="mul"+"(";;
				if(operations.get(j)==Operation.Max) a+="max"+"(";;
				if(operations.get(j)==Operation.Min) a+="min"+"(";;
				q=false;
				k++;
			}
			j++;
				a+=functions.get(i)+",";
				i++;
				a+=functions.get(i)+")";
				i++;
				return rqur(a,i,j,k,b,q);
			//if(!q)a+=",";
		//	l++;
			//if(k%2==0)a+=")";
		//if(i==0)	for (int l2 = 0; l2 < k; l2++) 	a+=")";
			
		}
		return a;
	}

	private String rqur(String a, int i, int j,int k,String b,boolean q) {
		if(i>=functions.size())return a;
		if(j<operations.size()) {
			if(operations.get(j)==Operation.Plus)b+="plus"+"(";;
			if(operations.get(j)==Operation.Divid)b+="div"+"(";;
			if(operations.get(j)==Operation.Times)b+="mul"+"(";;
			if(operations.get(j)==Operation.Max) b+="max"+"(";;
			if(operations.get(j)==Operation.Min) b+="min"+"(";;
			q=false;
			k++;
		}
		j++;
			b+=a+",";
			b+=functions.get(i)+")";
			i++;
			return rqur(b,i,j,k,"",q);
		
	}
	@Override
	public void plus(function f1) {
		// function v=f1.initFromString(f1.toString());
		functions.add(f1);
		operations.add( Operation.Plus);
		
	}

	@Override
	public void mul(function f1) {
		// function v=f1.initFromString(f1.toString());
			functions.add(f1);
			operations.add( Operation.Times);
	}

	@Override
	public void div(function f1) {
		// function v=f1.initFromString(f1.toString());
			functions.add(f1);
			operations.add( Operation.Divid);
	}

	@Override
	public void max(function f1) {
		//function v=f1.initFromString(f1.toString());
		functions.add(f1);
		operations.add( Operation.Max);
	}

	@Override
	public void min(function f1) {
	//	function v=f1.initFromString(f1.toString());
		functions.add(f1);
		operations.add( Operation.Min);
	}

	@Override
	public void comp(function f1) {
		//function v=f1.initFromString(f1.toString());
		functions.add(f1);
		operations.add( Operation.Comp);
	}

	@Override
	public function left() {
		return functions.get(0);
	}

	@Override
	public function right() {
		return functions.get(functions.size()-1);
	}

	@Override
	public Operation getOp() {
		return operations.get(0);
	}
	public String toString1() {
		return "";
	}
	public static void main(String[] args) {
		function x= new Monom("2x");
        function y= new Polynom("x+3");
        function j= new Polynom("x-2");
        function b= new Polynom("x-4");
        function n= new Polynom("2");
        function m= new Polynom("x+1");
        ComplexFunction f5=new ComplexFunction(y);
        f5.mul(j);
        f5.mul(b);
        ComplexFunction f4=new ComplexFunction(m);
        f4.div(f5);
        f4.plus(n);
        
        ComplexFunction f1 = new ComplexFunction("plus",x,y);//f1 ** f(x)=plus(2x,8x^2+8)
        ComplexFunction f2= new ComplexFunction("plus",f1,x);//f2** f(x)=plus(plus(2x,8x^2+8),2x)
        ComplexFunction f3 =new ComplexFunction("plus(2.0,div(mul(-4.0+x,mul(-2.0+x,3.0+x)),1+x))");
      
      System.out.println(f4);
        System.out.println(f3.f(8));
    

	}
}
