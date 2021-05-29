package com.example.fragmentexample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fragmentexample.R;

public class Fragment2 extends Fragment {

    private TextView mInfoTextView;
    private ImageView mCatImageView;
    private String[] mCatDescriptionArray; // массив строк


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, container, false); // присоединяем фрагмент в разметке
        mInfoTextView =  rootView.findViewById(R.id.textView);
        mCatImageView = rootView.findViewById(R.id.imageView);
        mCatDescriptionArray = getResources().getStringArray(R.array.cats); // присоединяем строки в массив

        return rootView;




    } // все фрагменты наследуются от Fragment


    public void setDescription(int buttonIndex) { // устанавливаем описание
        String catDescription = mCatDescriptionArray[buttonIndex]; // получаем его из индекса кнопки
        mInfoTextView.setText(catDescription);

        switch (buttonIndex) {
            case 1:
                mCatImageView.setImageResource(R.drawable.cat_yellow);
                break;
            case 2:
                mCatImageView.setImageResource(R.drawable.cat_white);
                break;
            case 3:
                mCatImageView.setImageResource(R.drawable.cat_green);
            default:
                break;


        }




    }


}
