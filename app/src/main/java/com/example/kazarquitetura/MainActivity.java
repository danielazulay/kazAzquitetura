package com.example.kazarquitetura;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enviaremail();

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.menu_principal,R.id.menu_email,R.id.menu_servicos,R.id.menu_informacao)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void enviaremail(){

        //String imagem="https://pt.wikipedia.org/wiki/Praia#/media/Ficheiro:Litoral_de_Portugal.jpg";
       String celular = "tel:11976384854";
         //String endereco = "https://www.google.com/maps/place/Rua+Dr.+Gabriel+dos+Santos,+511+-+Santa+Cecilia,+S%C3%A3o+Paulo+-+SP,+01231-011/data=!4m2!3m1!1s0x94ce5817c261eb85:0x826a2e2f81a1770a?sa=X&ved=2ahUKEwiKgP3ytbTpAhUiTt8KHaMABTAQ8gEwAHoECAsQAQ";
        //Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(celular));
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:11991618508"));
        //Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(imagem));
        //        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(endereco));
      //  Intent intent = new Intent(Intent.ACTION_SEND);
        //intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"carolsejtman@gmail.com"});
       // intent.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo App");
       // intent.putExtra(Intent.EXTRA_TEXT,"Boa tarde, gostaria de fazer um orçamento");
        // sitepoint.com/mine-types-complete-list/
        //intent.setType("message/rfc822");
      //  intent.setType("image");
        //intent.setType("text/plain");
        //intent.setType("image/*");


        startActivity(Intent.createChooser(intent,"Compartilha"));

        intent.setType("message/plain");
       // startActivity(intent);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
