package myMath;

import java.util.ArrayList;

public class ComplexFunction implements complex_function{
	private ArrayList<function> functions= new ArrayList<function>();
	private ArrayList<Operation> operations=new ArrayList<Operation>();;

	public  ComplexFunction(String s) {
		if(s.length()==0) throw new RuntimeException("ERR the  string sholdn't be empty , got: "+s);
		if((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(01)=='+') {
			functions.add(new Polynom(s));
			return;
		}
		while(!s.equals("")) {
			while(!((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(01)=='+'))s= this.op(s);
			while(!s.equals("")) {
				if((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(0)=='+')s= this.fun(s,"",0);
				else s=this.comlex(s,0,0,"");
				if(s.length()>0) if(s.charAt(0)==',')s=s.substring(1, s.length());
			}
		}
	}

	private String comlex(String s,int sum1,int sum2,String r) {
		for (int j = 0;  j <s.length() && s.charAt(j)!=')' ; j++)  if(s.charAt(j)=='(')sum1++; 
		int j = 0;
		for(; j <s.length() && sum2!=sum1; j++) {
			if(s.charAt(j)==')')sum2++;
			r+=s.charAt(j);
		}
		this.functions.add(new ComplexFunction(r));
		return s.substring(j+1, s.length());
	}

	private void addToStrat(Operation a) {
		ArrayList<Operation> operations1=new ArrayList<Operation>();
		for (int i = 0; i < operations.size(); i++) {
			operations1.add(operations.get(i));
		}
		this.operations=new ArrayList<Operation>();
		operations.add(a);
		for (int i = 0; i < operations1.size(); i++) {
			operations.add(operations1.get(i));
		}
	}

	private  String op(String s) {
		String r="";
		int j = 0;
		for ( ; j <s.length() && s.charAt(j)!='('; j++) 	r+=s.charAt(j);
		this.addToStrat(setOperation(r));
		return s.substring(j+1, s.length());
	}

	private String fun(String s,String r,int j) {
		for ( ; j < s.length()&&s.charAt(j)!=',' && s.charAt(j)!=')'; j++) 	r+=s.charAt(j);
		this.functions.add(new Polynom(r));
		return s.substring(j+1, s.length());
	}

	private  ComplexFunction(ComplexFunction p) {
		for (int i = 0; i < p.functions.size(); i++) functions.add(initFromString(p.functions.get(i).toString()));
		for (int i = 0; i < p.operations.size(); i++) {
			Operation  a=p.operations.get(i);
			operations.add(p.operations.get(i));
		}
	}

	public  ComplexFunction() {
		functions.add(new Monom(0,2));
	}

	public  ComplexFunction(function a) {
		function v=a.initFromString(a.toString());
		functions.add(v);
	}

	public  ComplexFunction(String s ,function  a,function b) {//לשנות לסטרינג
		operations.add(setOperation(s));
		if(setOperation(s).equals(Operation.None))throw new RuntimeException("ERR the  Monom should  be wife power afrer x or empty , got: "+s);
		function v=a.initFromString(a.toString());
		function v1=b.initFromString(b.toString());
		functions.add(v);
		functions.add(v1);
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
		else throw new RuntimeException("ERR the   string for operation not good , got: "+s);
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
			if(operations.get(j)==Operation.Comp) if(sum>functions.get(i).f(x))sum=functions.get(i).f(sum);
		}
		return sum;
	}
	public int size() {
		return  functions.size();
	}

	@Override
	public function initFromString(String s) {
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
		a+=functions.get(0);
		return rqur(a,1,0,"");
	}
	private String rqur(String a, int i, int j,String b) {
		if(i>=functions.size())return a;
		if(j<operations.size()) {
			if(operations.get(j)==Operation.Plus)b+="plus"+"(";
			if(operations.get(j)==Operation.Divid)b+="div"+"(";
			if(operations.get(j)==Operation.Times)b+="mul"+"(";
			if(operations.get(j)==Operation.Max) b+="max"+"(";
			if(operations.get(j)==Operation.Min) b+="min"+"(";
			if(operations.get(j)==Operation.Comp) b+="comp"+"(";
		}
		j++;
		b+=a+",";
		b+=functions.get(i)+")";
		i++;
		return rqur(b,i++,j++,"");
	}
	@Override
	public void plus(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Plus);

	}

	@Override
	public void mul(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Times);
	}

	@Override
	public void div(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Divid);
	}

	@Override
	public void max(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Max);
	}

	@Override
	public void min(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Min);
	}

	@Override
	public void comp(function f1) {
		function v=f1.initFromString(f1.toString());
		functions.add(v);
		operations.add( Operation.Comp);
	}

	@Override
	public function left() {
		ComplexFunction v=new ComplexFunction(this);
		v.functions.remove(v.functions.size()-1);
		v.operations.remove(v.operations.size()-1);
		return v;
	}

	@Override
	public function right() {
		function v=this.initFromString(functions.get(functions.size()-1).toString());
		return v;
	}

	@Override
	public Operation getOp() {
		if(operations.size()==0)return Operation.None;
	Operation a=operations.get(0);
		return a;
	}

	public static void main(String[] args) {
		Operation bn=Operation.Divid;
		Operation gv=bn;
		System.out.println(gv);
		ComplexFunction f16 = new ComplexFunction("0");
		ComplexFunction f6 = new ComplexFunction("min(min(min(min(plus(-1.0x^4+2.4x^2+3.1,0.1x^5-1.2999999999999998x+5.0),plus(div(1.0x+1.0,mul(mul(1.0x+3.0,+1.0x-2.0),1.0x-4.0)),2.0)),div(plus(-1.0x^4+2.4x^2+3.1,+0.1x^5-1.2999999999999998x+5.0),-1.0x^4+2.4x^2+3.1)),-1.0x^4+2.4x^2+3.1),+0.1x^5-1.2999999999999998x+5.0)");
		System.out.println(f6.right());
		System.out.println(f6.left());
		System.out.println(f6+"hj");
		System.out.println(f6.f(8));
		function x= new Monom("0");
		ComplexFunction f15=new ComplexFunction(x);
		System.out.println(f15);
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
		ComplexFunction f3 =new ComplexFunction("plus(div(1+x,mul(mul(3.0+x,-2.0+x),-4.0+x)),2.0)");
		System.out.println(f4.functions);
		System.out.println(f4);
		System.out.println(f3.f(8));


	}
}
