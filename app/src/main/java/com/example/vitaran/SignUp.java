package com.example.vitaran;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {

    private EditText etFname, etLname, etEmail, etAddress, etContact, etPassword, etRepassword;
    private Button register;
    private Context ctx=this;
    private String FNAME=null, LNAME=null, PASSWORD=null, EMAIL=null, LOCATION=null, CONTACT=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etFname = (EditText) findViewById(R.id.FName);
        etLname = (EditText) findViewById(R.id.LName);
        etFname.setNextFocusDownId(R.id.LName);
        etEmail = (EditText) findViewById(R.id.donor_email_id);
        etAddress = (EditText) findViewById(R.id.donor_address);
        etContact = (EditText) findViewById(R.id.donor_contact);
        etPassword = (EditText) findViewById(R.id.donor_password);
        etRepassword = (EditText) findViewById(R.id.donor_pass_rematch);
        register = (Button) findViewById(R.id.register_donor);

        // Adding listener to first name EditText for verifying correct format
        etFname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    //Toast.makeText(SignUp.this,"Bye",Toast.LENGTH_LONG).show();
                    if (etFname.getText().toString().isEmpty())
                        etFname.setError("This field is required");
                    else if (!isValidName(etFname.getText().toString().trim()))
                        etFname.setError("Invalid Name");
                    return;
                }
            }
        });

        // Adding listener to last name EditText for verifying correct format
        etLname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    //Toast.makeText(SignUp.this,"Bye",Toast.LENGTH_LONG).show();
                    if (etLname.getText().toString().isEmpty())
                        etLname.setError("This field is required");
                    else if (!isValidName(etLname.getText().toString().trim()))
                        etLname.setError("Invalid Name");
                    return;
                }
            }
        });

        // Adding listener to email EditText for verifying correct format
        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus == false) {
                    //Toast.makeText(SignUp.this,"Bye",Toast.LENGTH_LONG).show();
                    if (etEmail.getText().toString().isEmpty())
                        etEmail.setError("This field is required");
                    else if (!isValidEmailID(etEmail.getText().toString().trim()))
                        etEmail.setError("Invalid Email Id");
                    return;
                }
            }
        });

        // Adding listener to Register Button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptRegistration();
            }
        });
    }

    private void attemptRegistration() {

        // Reset errors.
        etFname.setError(null);
        etLname.setError(null);
        etEmail.setError(null);
        etAddress.setError(null);
        etContact.setError(null);
        etPassword.setError(null);
        etRepassword.setError(null);

        // Store values at the time of the registration attempt.
        String firstName = etFname.getText().toString();
        String lastName = etLname.getText().toString();
        String emailID = etEmail.getText().toString();
        String address = etAddress.getText().toString();
        String phone = etContact.getText().toString();
        String pswrd = etPassword.getText().toString();
        String repswrd = etRepassword.getText().toString();

        Boolean cancel = false;
        View focusView = null;

        // Check for a valid firstName & lastName
        if (firstName.isEmpty()) {
            etFname.setError("This field is required");
            focusView = etFname;
            cancel = true;
        } else if(!isValidName(firstName)) {
            etFname.setError("Re-enter a valid name");
            focusView = etFname;
            cancel = true;
        }
        if (lastName.isEmpty()) {
            etLname.setError("This field is required");
            focusView = etLname;
            cancel = true;
        } else if (!isValidName(lastName)){
            etLname.setError("Re-enter a valid name");
            focusView = etLname;
            cancel = true;
        }

        // Check for a valid EmailId
        if (emailID.isEmpty()) {
            etEmail.setError("This field is required");
            focusView = etEmail;
            cancel = true;
        } else if (!isValidEmailID(emailID.trim())){
            etEmail.setError("Re-enter a valid email Id");
            focusView = etEmail;
            cancel = true;
        }

        // Check for a valid etContact number
        if (phone.isEmpty()) {
            etContact.setError("This field is required");
            focusView = etContact;
            cancel = true;
        } else if (!isValidContact(phone)) {
            etContact.setError("Re-enter a valid Contact Number");
            focusView = etContact;
            cancel = true;
        }

        // Check for a valid password
        if (pswrd.isEmpty()) {
            etPassword.setError("This field is required");
            focusView = etPassword;
            cancel = true;
        }

        // Check for a valid re-password
        if (repswrd.isEmpty()) {
            etRepassword.setError("This field is required");
            focusView = etRepassword;
            cancel = true;
        } else if (!isValidRePassword(pswrd, repswrd)) {
            etRepassword.setError("Passwords DO NOT match");
            focusView = etRepassword;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            register(firstName, lastName, emailID, address, phone, pswrd);
        }
    }

    // Methods for validation of User input.

    private Boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        return !TextUtils.isEmpty(name) && pattern.matcher(name).matches();
    }

    private Boolean isValidEmailID(String emailID) {
        return !TextUtils.isEmpty(emailID) && android.util.Patterns.EMAIL_ADDRESS.matcher(emailID).matches();
    }

    private Boolean isValidContact(String number) {
        return android.util.Patterns.PHONE.matcher(number).matches();
    }

    private Boolean isValidPassword(String pass) {
        return true;
    }

    private Boolean isValidRePassword(String passkey, String repasskey) {
        return passkey.equals(repasskey);
    }

    private void register(String fname,String lname,String email,String pass,String location,String contact) {
        BackGround backGround = new BackGround();
        backGround.execute(fname,lname,email,pass,location,contact);
    }

    class BackGround extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... params) {
            String fname = params[0];
            String lname = params[1];
            String email = params[2];
            String password = params[3];
            String location = params[4];
            String contact = params[5];
            String data="";
            int tmp;

            try {
                URL url = new URL("http://127.0.0.1/app/register.php");
                String urlParams = "fname="+fname+"&lname="+lname+"&email="+email+
                        "&password="+password+"&location="+location+"&contact="+contact;

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //httpURLConnection.setInstanceFollowRedirects(true);
                connection.setReadTimeout(10000 /*milliseconds*/);
                connection.setConnectTimeout(55000 /* milliseconds */);
                connection.setDoInput(true);
                connection.setDoOutput(true);
                connection.setRequestMethod("POST");
                connection.connect();

                OutputStream os = connection.getOutputStream();
                os.write(urlParams.getBytes());
                os.flush();
                os.close();
                InputStream is = connection.getInputStream();
                while((tmp=is.read())!=-1){
                    data+= (char)tmp;
                }
                is.close();
                connection.disconnect();
                return data;

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "Exception1: "+e.getMessage();
            } catch (IOException e) {
                e.printStackTrace();
                return "Exception2: "+e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s.equals("")){
                s="Data saved successfully.";
            }
                Toast.makeText(ctx, s, Toast.LENGTH_LONG).show();
        }
    }
}
