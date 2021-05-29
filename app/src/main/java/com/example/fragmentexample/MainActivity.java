package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.example.fragmentexample.fragments.Fragment1;
import com.example.fragmentexample.fragments.Fragment2;

public class MainActivity extends AppCompatActivity implements Fragment1.OnSelectedButtonListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onButtonSelected(int buttonIndex) { // индекс получаем после нажатия кнопки
        FragmentManager fragmentManager = getSupportFragmentManager(); // подключаем менеджер для подключения второго фрагмента

        Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2); // получаем ссылку на второй фрагмент через его идентификатор и вызываем его метод setDescription().
        if(fragment2 != null)
            fragment2.setDescription(buttonIndex); // подключаем фрагмент по индексу
    }
}