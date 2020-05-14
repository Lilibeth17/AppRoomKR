package com.karenreal.approomkr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.karenreal.approomkr.fragments.Fragment_bono_regalo;
import com.karenreal.approomkr.fragments.Fragment_compartir;
import com.karenreal.approomkr.fragments.Fragment_contacto;
import com.karenreal.approomkr.fragments.Fragment_principal;
import com.karenreal.approomkr.fragments.Fragment_promociones;
import com.karenreal.approomkr.fragments.Fragment_quienes_somos;
import com.karenreal.approomkr.fragments.Fragment_reservas;

public class ActivityMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);

        //establecer evento onclick

        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new Fragment_principal());
        fragmentTransaction.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId()) {
            case R.id.home:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_principal());
                fragmentTransaction.commit();
                break;
            case R.id.lista:
                startActivity(new Intent(this, ActivityPublico.class));
                break;
            case R.id.buscar:
                startActivity( new Intent(this, Activity_Buscar.class));
                break;
            case R.id.reserva:
                break;
            case R.id.bono:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_bono_regalo());
                fragmentTransaction.commit();
                break;
            case R.id.promociones:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_promociones());
                fragmentTransaction.commit();
                break;
            case R.id.quienes:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_quienes_somos());
                fragmentTransaction.commit();
                break;
            case R.id.contacto:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_contacto());
                fragmentTransaction.commit();
                break;
            case R.id.compartir:
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new Fragment_compartir());
                fragmentTransaction.commit();
                break;
            case R.id.cerrarsesion:
                FirebaseAuth.getInstance().signOut();
                finish();
                break;
        }
        return false;
    }

}
