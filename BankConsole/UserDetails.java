package BankConsole;

public class UserDetails {
 private String name;
 private String password;
 private String mobileNumber;
 private  String accountNumber;
 
public UserDetails(String name, String password, String mobileNumber, String accountNumber) {
    this.name = name;
    this.password = password;
    this.mobileNumber = mobileNumber;
    this.accountNumber = accountNumber;
}
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public String getMobileNumber() {
    return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
}
@Override
public String toString(){
    return("Name-"+name+"MobileNumber-"+mobileNumber+"Account"+accountNumber);

} 
 
// @Override

// public boolean equals(Object obj){
//     UserDetails user=(UserDetails)obj;
//     return(this.name.equals(user.getName()) && this.accountNumber.equals(user.getAccountNumber()) && this.password.equals(user.getPassword()) );

// }

public String getAccountNumber() {
    return accountNumber;
}
public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
}

}
