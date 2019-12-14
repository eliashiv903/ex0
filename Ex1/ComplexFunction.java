package Ex1;

import java.util.ArrayList;

public class ComplexFunction implements complex_function{
	public ArrayList<function> functions= new ArrayList<function>();
	public ArrayList<Operation> operations=new ArrayList<Operation>();

	public  ComplexFunction(String s) {
		if(s.length()==0) throw new RuntimeException("ERR the  string sholdn't be empty , got: "+s);
		if((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(0)=='+'|| s.charAt(0)=='x') {
			functions.add(new Polynom(s));
			return;
		}
		if(!((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(0)=='+'||s.charAt(0)==','||s.charAt(0)==')'||s.charAt(0)=='('))s= this.op(s,"",0);
		while(!s.equals("")) {
			if((s.charAt(0)>='0' && s.charAt(0)<='9')||s.charAt(0)=='-' || s.charAt(0)=='+'|| s.charAt(0)=='x')s= this.polynom(s,"",0);
			else if(s.charAt(0)>='c' && s.charAt(0)<='p'&&s.charAt(0)!='x') s=this.comlex(s,1,0,"");
			else {
				throw new RuntimeException("ERR the   string  not legal: "+s);
			}

		}

	}
	private String comlex(String s,int sum1,int sum2,String r) {
		int j = 0;
		for (; j < s.length()&&s.charAt(j)!='('; j++) {
			r+=s.charAt(j);
		}
		r+=s.charAt(j);
		j++;
		for (;  j <s.length() && sum1!=sum2 ; j++) {
			r+=s.charAt(j);
			if(s.charAt(j)==')')sum2++;
			if(s.charAt(j)=='(')sum1++; 
		}
		this.functions.add(new ComplexFunction(r));
		if(j+1>=s.length()||s.length()==0)return "";
		return s.substring(j+1, s.length());
	}

	private void addOpToStrat(Operation a) {
		ArrayList<Operation> operations1=new ArrayList<Operation>();
		for (int i = 0; i < operations.size(); i++) operations1.add(operations.get(i));
		this.operations=new ArrayList<Operation>();
		operations.add(a);
		for (int i = 0; i < operations1.size(); i++) operations.add(operations1.get(i));
	}
	private  String op(String s,String r,int j) {
		for ( ; j <s.length() && s.charAt(j)!='('; j++) 	r+=s.charAt(j);
		this.addOpToStrat(setOperation(r));
		return s.substring(j+1, s.length());
	}
	private String polynom(String s,String r,int j) {
		for ( ; j < s.length()&&s.charAt(j)!=',' && s.charAt(j)!=')'; j++) 	r+=s.charAt(j);
		this.functions.add(new Polynom(r));
		if(j+1>=s.length())return "";
		if(s.charAt(j+1)==',')j++;
		return s.substring(j+1, s.length());
	}
	private void err(String s,int count1,int count2) {
		for (int j = 0;  j <s.length() ; j++) {
			if(s.charAt(j)=='(')count1++;
			if(s.charAt(j)==',')count2++;
		}
		if(count1!=count2)throw new RuntimeException("ERR the   string for not legalo00: "+s);
	}

	public  ComplexFunction(ComplexFunction p) {
		for (int i = 0; i < p.functions.size(); i++) functions.add(initFromString(p.functions.get(i).toString()));
		for (int i = 0; i < p.operations.size(); i++) {
			Operation  a=p.operations.get(i);
			operations.add(a);
		}
	}

	public  ComplexFunction() {
		functions.add(new Monom(0,2));
	}

	public  ComplexFunction(function a) {
		function v=a.initFromString(a.toString());
		functions.add(v);
	}
	public  ComplexFunction(Operation op ,function  a,function b) {
		Operation c=op;
		operations.add(c);
		if(c.equals(Operation.None))throw new RuntimeException("ERR the  Operation not ligel , got: "+op);
		function v=a.initFromString(a.toString());
		function v1=b.initFromString(b.toString());
		functions.add(v);
		functions.add(v1);
	}
	public  ComplexFunction(String s ,function  a,function b) {
		operations.add(setOperation(s));
		function v=a.initFromString(a.toString());
		function v1=b.initFromString(b.toString());
		functions.add(v);
		functions.add(v1);
	}
	public static  Operation setOperation(String s) {
		Operation c;
		if(s.equals("plus"))return Operation.Plus;
		else if(s.equals("mul"))return Operation.Times;
		else if(s.equals("max"))return Operation.Max;
		else if(s.equals("div"))return Operation.Divid;
		else if(s.equals("min"))return Operation.Min;
		else if(s.equals("comp"))return Operation.Comp;
		else throw new RuntimeException("ERR the   string for operation not good , got: "+s);
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
		err(s,0,0);
		return new ComplexFunction(s);
	}

	@Override
	public function copy() {
		return new ComplexFunction(this);
	}

	public boolean equals(Object obj) {
		ComplexFunction a=new ComplexFunction(obj.toString());
		double x=100;
		for (int i = 0; i < 120; i++,x+=0.1) if(a.f(x)-this.f(x)>0.0000001 && a.f(x)-this.f(x)<-0.0000001) 		return false;
		x=-100;
		for (int i = 0; i < 120; i++,x-=0.1) if(((a.f(x)-this.f(x))>0.0000001) && (a.f(x)-this.f(x))<-0.0000001)return false;	
		return true;
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
		functions.add(f1.initFromString(f1.toString()));
		operations.add( Operation.Plus);

	}

	@Override
	public void mul(function f1) {
		functions.add(f1.initFromString(f1.toString()));
		operations.add( Operation.Times);
	}

	@Override
	public void div(function f1) {
		functions.add(f1.initFromString(f1.toString()));
		operations.add( Operation.Divid);
	}

	@Override
	public void max(function f1) {
		functions.add(f1.initFromString(f1.toString()));
		operations.add( Operation.Max);
	}

	@Override
	public void min(function f1) {
		functions.add(f1.initFromString(f1.toString()));
		operations.add( Operation.Min);
	}

	@Override
	public void comp(function f1) {
		functions.add(f1.initFromString(f1.toString()));
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
		return this.initFromString(functions.get(functions.size()-1).toString());
	}
	@Override
	public Operation getOp() {
		if(operations.size()==0)return Operation.None;
		Operation a=operations.get(operations.size()-1);
		return a;
	}
	
}
