package id.duza.loginapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// MainActivity adalah subclass (anak class) dari AppCompatActivity yang merupakan superclass (Ibu class)
//AppCompatActivity : Base class dari activity
public class MainActivity extends AppCompatActivity {

    //Global variable
    // Deklarasi variable dengan hak akses private
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    private String username;

    //Override : Memodifikasi method yang berada di super class "AppCompatActivity"
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // melekatkan java dengan layout activity_main
        setContentView(R.layout.activity_main);

        setupView();
        setupViewListener();
    }

    //Method buatan sendiri biar rapi codingannya
    private void setupViewListener() {
        // memberi aksi ketika btnLogin di klik oleh user
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menampilkan message Login success / Login failed
                // ...? ... : ... adalah ternary operator yg gunanya sama seperti if else dan hanya bisa untuk case tertentu
                Toast.makeText(MainActivity.this, isValid()? "Login success" : "Login failed",
                        Toast.LENGTH_SHORT).show();
                if (isValid())  {
                    //Intent digunakan untuk pertukaran data antar activity / pindah activity
                    //Bayangkan intent adalah amplop
                    //                         Dari mana          Tujuannya kemana
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);

                    //intent.putExtra(..) : klo pengen mindah/kirim data ke WelcomeActivity, klo engga silahkah hapus aja :D
                    intent.putExtra(Intent.EXTRA_TEXT, username); //kita mengirim username ke WelcomeActivity

                    // startActivity sama seperti kita memberi amplop/surat kepada kurir surat misal JNE dll
                    startActivity(intent);
                }

                //terserah pilih yg atas atau yg bawah
//
//                if (isValid())  {
//                    Toast.makeText(MainActivity.this, "Login success", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    // method untuk validasi data jika user&pass nya bener maka return true else return false
    private boolean isValid()   {
        // mengambil text dari EditText etUsername lalu dikonvert ke String
        username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        //String username nya ditaruh di global variable / diatau knp ga disini??
        //Agar username dapat diakses di method manapun (dipakai disini dan di setupViewListener method)
        //Sedangkan string password hanya digunakan disini (maka String password local variable)

        // .equals(..) sama seperti ==

//        if (username.equals("admin") && password.equals("pass"))    {
//            return true;
//        } else {
//            return false;
//        }

        // codingan diatas dengan dibawah ini sama saja hasil nya

        return username.equals("admin") && password.equals("pass");
    }

    //Method ini buatan sendiri
    //digunakan untuk menginisialisasi variable etUsername, etPassword, btnLogin
    //Knp dibuat method ini,,, karena biar rapi :)
    private void setupView() {
        // findViewById(..) : untuk mencari view menggunakan id
        // dengan begitu berarti kita sudah merekatkan variablenya dengan view nya
        etUsername = (EditText) findViewById(R.id.et_main_username);
        etPassword = (EditText) findViewById(R.id.et_main_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        // kok EditText nya didalem kurung?? (EditText)
        // findViewById mengembalikan type data View, sedangkan
        // variable yang kita buat menggunakan variable EditText, Button
        // Berarti kita butuh type casting dari view ke EditText / Button
    }
}
