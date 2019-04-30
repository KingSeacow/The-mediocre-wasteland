
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
class PhoneBookEntry implements Serializable  {
    private String Name;
    private String Last;
    private String Address;
    private String Phone;
    //constructor
    PhoneBookEntry(String name,String last,String address,String phone){
        this.Name=name;
        this.Last=last;
        this.Address=address;
        this.Phone=phone;
    }
    //get name
    public String getName(){
        return Name;
    }
    //get last
    public String getLast(){
        return Last;
    }
    //get  address
    public String getAddress(){
        return Address;
    }
    //get phone number
    public String getPhone(){
        return Phone;
    }
    //print entry information
    public void printInfo(){
        System.out.println("Name:"+Name+ "\nLast Name: " + Last + "\nAddress: " + Address +"\nPhone:"+Phone +"\n");
    }
}

public class PhoneBook {
    static Hashtable<String,PhoneBookEntry> phonebook; 

   

    		
    public static void main(String[] args){
        phonebook=readList(); //read phonebook
        int ch;
        //character varible thats continues the code process.
        char con='y';
        Scanner sc=new Scanner(System.in); //create scanner object to receive choice input
        while(con=='y'){
            showMenu(); //show menu
            System.out.println("Enter your choice:");
            ch=sc.nextInt();    
            switch(ch){
                case 1:viewAll();break;
                case 2:addToPhoneBook();break;
                case 3:deleteFromPhonebook();break;
                case 4:searchByName();break;
                case 5:System.exit(0);break;
                default: System.out.println("Invalid choice");
            }
            try{
                //prompt for continuing the program
                InputStreamReader isr=new InputStreamReader(System.in);
                System.out.println("Press y to continue:");
                con=(char)isr.read();
            }catch(IOException ie) {  
            }
        }
    }
    //The viewAll method displays all entries in the phonebook
    public static void viewAll(){
        if(phonebook!=null){
            for(Enumeration<String> e=phonebook.keys(); e.hasMoreElements();){
                PhoneBookEntry entry=phonebook.get(e.nextElement());
                entry.printInfo();
                //System.out.println("hmm");
            }
        }
    }
    //The addToPhoneBook method is able to add each entry to the phonebook
    public static void addToPhoneBook(){
        //If the phonebook null, allocate memory for it so it is ready to get the new item
        if(phonebook==null) phonebook=new Hashtable<String,PhoneBookEntry>();
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name: ");
            String name=br.readLine();    
            System.out.println("Enter Last name: ");
            String last=br.readLine(); 
            System.out.println("Enter Address: ");
            String address=br.readLine();  
            System.out.println("Enter phone:");
            String phone=br.readLine();   
            PhoneBookEntry st=new PhoneBookEntry(name,last,address, phone);
            phonebook.put(name,st); //add new entry to the phonebook
            writeIt(phonebook); //save the update phonebook
        }catch(IOException e){}
    }
    //The deleteFromPhonebook method is able to delete an entry when the name
    //is correctly input
    public static void deleteFromPhonebook(){
        if(phonebook!=null){
            int si=phonebook.size(); //number of entries in the phonebook before an entry is removed
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Name:");
                String key=br.readLine();
                phonebook.remove(key); //remove the contact
                if(phonebook.size()<si){ //removing is successful
                    writeIt(phonebook);
                    System.out.println("The entry has been deleted.");
                }
                else
                    System.out.println("Wrong name");
            }catch(IOException ie){
            }
        }
    }
    //The searchByName method has code to find a phonebook entry by name in the list
    public static void searchByName(){
        if(phonebook!=null){
            try{
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Search by name:");
                String key=br.readLine();
                PhoneBookEntry cu=phonebook.get(key);
                if(cu!=null)
                    cu.printInfo();

                else
                    System.out.println("Not found");
            }catch(IOException ie){
            }
        }
    }
    //Write the Hashtable object representing the phonebook to the file
    public static void writeIt(Hashtable<String,PhoneBookEntry> obj){
        try{
            FileOutputStream fos=new FileOutputStream("phonebook.txt");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
            oos.close();
        }catch(IOException ie){
        }
    }
    //The readList method has code to read phonebook from the file
    public static Hashtable<String,PhoneBookEntry> readList(){
        Hashtable<String,PhoneBookEntry> phbook=null;
        try{
            FileInputStream fis=new FileInputStream("phonebook.txt");
            ObjectInputStream ois=new ObjectInputStream(fis);
            phbook=(Hashtable<String,PhoneBookEntry>)ois.readObject();
            ois.close();
        }   catch(Exception ie){
        }
        return phbook;
    } 
    //This method display options menu
    public static void showMenu(){
        System.out.print('\u000C');
        System.out.println("");
        System.out.println("1. View all phonebook entries");
        System.out.println("2. Add to phonebook");
        System.out.println("3. Remove from phonebook");
        System.out.println("4. Find an entry"); 
        System.out.println("5. Exit");
    }
    
}