package com.example.fragmentexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fragmentexample.R;

public class Fragment1 extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) { // подключаем вью перед стартом самого фрагмента
        View rootView =  inflater.inflate(R.layout.fragment1, container, false);

        Button button1 = (Button) rootView.findViewById(R.id.button1); // присоединяем кнопки
        Button button2 = (Button) rootView.findViewById(R.id.button2);
        Button button3 = (Button) rootView.findViewById(R.id.button3);

        button1.setOnClickListener(this); // устанавливаем слушатель событий, теперь по кнопкам можно кликать
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View view) { // что выводить при нажатии кнопок
        int buttonIndex = translatedIdToIndex(view.getId());
        OnSelectedButtonListener listener = (OnSelectedButtonListener) getActivity(); // слушатель событий при нажатий кнопки
        assert listener != null;
        listener.onButtonSelected(buttonIndex); //  передали индекс после нажатия кнопки

        /*
        Toast.makeText(getActivity(), "Вы нажали на кнопку", Toast.LENGTH_SHORT).show();
        */

    }


    int translatedIdToIndex(int id) { // нужно, чтобы узнать какая кнопка была нажата
        int index = -1;
        switch (id) {
            case R.id.button1:
                index = 1;
                break;
            case R.id.button2:
                index = 2;
                break;
            case R.id.button3:
                index = 3;
                break;
        }
        return index;
    }

    public interface OnSelectedButtonListener { // получаем индекс кнопки
        void onButtonSelected(int buttonIndex);
    }


}
