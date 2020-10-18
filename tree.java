import java.io.*;
import java.util.Scanner;
public class tree {
	private int num;	//number of sons
	private int temp;	//keep in track of how many sons not in the tree yet
	private String name;
	private tree left, right, father;
	
	tree(){
		this(null, 0);		
	}
	
	tree(String name, int num){
		this.name = name;
		this.num = num;
		this.temp = num;
		this.left = null;
		this.right = null;
		this.father = null;
	}
	
	private void addleft(String name, int num){
		if (this.left != null) {      
		     System.out.println( "Can¡¯t add left son, something is already there");
		    } else {
		    	tree q = new tree(name, num);
		    	this.left = q;
		    	q.father = this;
		    }
	}
	
	private void addright(String name, int num){
		if (this.right != null) {      
	     System.out.println( "Can¡¯t add right son, something is already there");
	    } else {
	    	tree q = new tree(name, num);
	    	this.right = q;
	    	q.father = this;
	    }
	}

	public static void main(String[] args) throws IOException {
		File file1 = new File("C:\\Users\\peng\\Desktop\\CISC 3130\\java\\son.txt");
		Scanner input = new Scanner(file1);
		
		File file = new File("C:\\Users\\peng\\Desktop\\CISC 3130\\java\\output.txt");
		PrintWriter output = new PrintWriter(file);
		
		tree root = new tree(input.next(), input.nextInt());
		output.println(root.name + " " + root.num);
		while (input.hasNext()) {
			intrav(root, output, input);
		}
		output.println();
		intrav(root, output, "Bob");
		intrav(root, output, "Jones");
		intrav(root, output, "Michael");
		intrav(root, output, "Dan");
		intrav(root, output, "Brian");
		intrav(root, output, "Richard");
		intrav(root, output, "Jake");
		intrav(root, output, "Bill");
		intrav(root, output, "Deville");
		
		output.flush();
		output.close();
		input.close();
	}
	
	public static void intrav(tree p, PrintWriter output, Scanner input) throws IOException{
        if (p!=null){
        intrav(p.left, output, input);
        tree temp = new tree();
        if (p.temp > 0) {
        	p.addleft(input.next(), input.nextInt());
        	temp = p.left;
    		output.println(temp.name + " " + temp.num);
        	p.temp--;
        }
        while(p.temp > 0) {
        	temp.addright(input.next(), input.nextInt());
        	temp = temp.right;
    		output.println(temp.name + " " + temp.num);
        	p.temp--;
        }
        intrav(p.right, output, input);
        }
    }
	
	public static void intrav(tree p, PrintWriter output, String name) throws IOException{
        if (p!=null){
        intrav(p.left, output, name);
        if (p.name.equals(name)) {
        	father(p, output);
        	sons(p, output);
        	brothers(p, output);
        	oldbrother(p, output);
        	youngbrother(p, output);
        	oldson(p, output);
        	youngson(p, output);
        	uncles(p, output);
        	grandfather(p, output);
        }
        intrav(p.right, output, name);
        }
    }
	
	public static void father(tree p, PrintWriter output) throws IOException{
		if (p.father == null) {
			output.println(p.name + " does not have father");
		} else {
			tree temp = p;
			while (temp.father.left != temp) {
				temp = temp.father;
			}
			output.println(p.name + "'s father: " + temp.father.name);
		}
	}
	
	public static void sons(tree p, PrintWriter output) throws IOException{
		if (p.left == null) {
			output.println(p.name + " does not have son");
		} else {
			output.print(p.name + "'s sons: " + p.left.name);
			tree temp = p.left;
			while (temp.right != null) {
				output.print(" " + temp.right.name);
				temp = temp.right;
			}
			output.println();
		}
	}
	
	public static void brothers(tree p, PrintWriter output) throws IOException{
		if (p.father == null || p.right == null && p.father.left == p) {
			output.println(p.name + " does not have brother");
		} else {
			output.print(p.name + "'s brothers: ");
			tree temp = p;
			while (temp.father.left != temp) {
				output.print(temp.father.name + " ");
				temp = temp.father;
			}
			temp = p;
			while (temp.right != null) {
				output.print(temp.right.name + " ");
				temp = temp.right;
			}
			output.println();
		}
	}
	
	public static void oldbrother(tree p, PrintWriter output) throws IOException{
		if (p.father == null || p.right == null && p.father.left == p) {
			output.println(p.name + " does not have oldest brother");
		} else if (p.father.left == p) {
			output.println(p.name + " is the oldest brother");
		} else {
			tree temp = p;
			while (temp.father.left != temp) {
				temp = temp.father;
			}
			output.println(p.name + "'s oldest brother: " + temp.name);
		}
	}
	
	public static void youngbrother(tree p, PrintWriter output) throws IOException{
		if (p.father == null || p.right == null && p.father.left == p) {
			output.println(p.name + " does not have youngest brother");
		} else if (p.right == null) {
			output.println(p.name + " is the youngest brother");
		} else {
			tree temp = p;
			while (temp.right != null) {
				temp = temp.right;
			}
			output.println(p.name + "'s youngest brother: " + temp.name);
		}
	}
	
	public static void oldson(tree p, PrintWriter output) throws IOException{
		if (p.left == null) {
			output.println(p.name + " does not have son");
		} else {
			output.println(p.name + " oldest son: " + p.left.name);
		}
	}
	
	public static void youngson(tree p, PrintWriter output) throws IOException{
		if (p.left == null) {
			output.println(p.name + " does not have son");
		} else {
			tree temp = p.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			output.println(p.name + " youngest son: " + temp.name);
		}
	}
	
	public static void uncles(tree p, PrintWriter output) throws IOException{
		if (p.father == null || p.father.father == null || p.father.right == null && p.father.father.left == p.father) {
			output.println(p.name + " does not have uncle");
		} else {
			tree temp = p;
			while (temp.father.left != temp) {
				temp = temp.father;
			}
			tree temp1 = temp.father;
			if (temp1.father == null && temp1.right == null) {
				output.print(p.name + " does not have uncle");
			} else {
				output.print(p.name + "'s uncles: ");
				if (temp1.father != null) {
					while (temp1.father.left != temp1) {
						output.print(temp1.father.name + " ");
						temp1 = temp1.father;
					}
				}
				temp = temp.father;
				while (temp.right != null) {
					output.print(temp.right.name + " ");
					temp = temp.right;
				}
			}
			output.println();
		}	
	}
	
	public static void grandfather(tree p, PrintWriter output) throws IOException{
		if (p.father == null) {
			output.println(p.name + " does not have a grandfather");
		} else {
			tree temp = p;
			while (temp.father.left != temp) {
				temp = temp.father;
			}
			if (temp.father == null) {
				output.println(p.name + " does not have a grandfather");
			} else {
				temp = temp.father;
				if (temp.father == null) {
					output.println(p.name + " does not have a grandfather");
				} else {
					while (temp.father.left != temp) {
						temp = temp.father;
					}
					temp = temp.father;
					output.println(p.name + "'s grandfather: " + temp.name);
				}
			}
		}	
		output.println();
	}
}
