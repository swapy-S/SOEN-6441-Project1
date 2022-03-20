 package models;

 import com.fasterxml.jackson.annotation.JsonProperty;
 import java.util.List;

 public class ProfileInformation{

     public String owner_id;
     public String username;
     public String registration_date;
     public String limited_account;
     public String display_name;
     public String country;
     public String role;
     public String email_status;
     public String accepted_currency;
     public List<ProjectProfile> projectProfile =null;
     public String publicName;

     public String getPublicName() {
         return publicName;
     }

     public void setPublicName(String publicName) {
         this.publicName = publicName;
     }

     public String getOwner_id() {
         System.out.println(this.owner_id);
         return this.owner_id;
     }

     public void setOwner_id(String owner_id) {
         this.owner_id = owner_id;
     }

     public String getUsername() {
         return this.username;
     }

     public void setUsername(String username) {
         this.username = username;
     }

     public String getRegistration_date() {
         return this.registration_date;
     }

     public void setRegistration_date(String registration_date) {
         this.registration_date = registration_date;
     }

     public String getLimited_account() {
         return this.limited_account;
     }

     public void setLimited_account(String limited_account) {
         this.limited_account = limited_account;
     }

     public String getDisplay_name() {
         return this.display_name;
     }

     public void setDisplay_name(String display_name) {
         this.display_name = display_name;
     }

     public String getCountry() {
         return this.country;
     }

     public void setCountry(String country) {
         this.country = country;
     }

     public String getRole() {
         return role;
     }

     public void setRole(String role) {
         this.role = role;
     }

     public String getEmail_status() {
         return this.email_status;
     }

     public void setEmail_status(String email_status) {
         this.email_status = email_status;
     }

     public String getAccepted_currency() {
         return this.accepted_currency;
     }

     public void setAccepted_currency(String accepted_currency) {
         this.accepted_currency = accepted_currency;
     }

     public List<ProjectProfile> getProjectProfile() {
         return projectProfile;
     }

     public void setProjectProfile(List<ProjectProfile> projectProfile) {
         this.projectProfile = projectProfile;
     }
 }
