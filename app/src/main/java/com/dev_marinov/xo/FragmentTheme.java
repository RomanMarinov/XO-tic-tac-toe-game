package com.dev_marinov.xo;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.Context.MODE_MULTI_PROCESS;


public class FragmentTheme extends Fragment{

    View frag;

    ImageView img_theme_1, img_theme_2, img_theme_3, img_theme_4, img_theme_5, img_theme_6, img_theme_7, img_theme_8, img_theme_9, img_theme_10, img_theme_11, img_theme_12;
    ImageView img_theme_2_unlock, img_theme_3_unlock, img_theme_4_unlock, img_theme_5_unlock, img_theme_6_unlock, img_theme_7_unlock, img_theme_8_unlock,
            img_theme_9_unlock, img_theme_10_unlock, img_theme_11_unlock, img_theme_12_unlock;


    ConstraintLayout cl_interior_theme_unlock;
    Button bt_unlocked_theme;
    TextView tv_message_unblock_theme;

    LinearLayout ll_conteiner_bt;

    ConstraintLayout cl_main;
    String temp_value_theme;

    SharedPreferences sharedPreferences;

    String status_lock = "locked";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        frag = inflater.inflate(R.layout.fragment_theme, container, false);

        img_theme_1 = frag.findViewById(R.id.img_theme_1);
        img_theme_2 = frag.findViewById(R.id.img_theme_2);
        img_theme_3 = frag.findViewById(R.id.img_theme_3);
        img_theme_4 = frag.findViewById(R.id.img_theme_4);
        img_theme_5 = frag.findViewById(R.id.img_theme_5);
        img_theme_6 = frag.findViewById(R.id.img_theme_6);
        img_theme_7 = frag.findViewById(R.id.img_theme_7);
        img_theme_8 = frag.findViewById(R.id.img_theme_8);
        img_theme_9 = frag.findViewById(R.id.img_theme_9);
        img_theme_10 = frag.findViewById(R.id.img_theme_10);
        img_theme_11 = frag.findViewById(R.id.img_theme_11);
        img_theme_12 = frag.findViewById(R.id.img_theme_12);

        ll_conteiner_bt = frag.findViewById(R.id.ll_conteiner_bt);

        cl_main = frag.findViewById(R.id.cl_main);



// нажатие кнопок во фрагменте FragmentTheme где происходит выбор другой темы для игры
        img_theme_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "1";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.white));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });

        img_theme_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "2";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.white));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "3";

                saveSettingString("i_choose_this_theme", temp_value_theme);

                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.white));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "4";

                saveSettingString("i_choose_this_theme", temp_value_theme);

                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.white));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "5";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.white));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "6";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.white));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "7";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.white));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "8";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.white));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "9";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.white));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "10";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.white));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "11";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.white));
                img_theme_12.setBackground(getResources().getDrawable(R.color.select_one_theme));
            }
        });
        img_theme_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp_value_theme = "12";

                saveSettingString("i_choose_this_theme", temp_value_theme);
                img_theme_1.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_2.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_3.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_4.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_5.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_6.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_7.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_8.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_9.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_10.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_11.setBackground(getResources().getDrawable(R.color.select_one_theme));
                img_theme_12.setBackground(getResources().getDrawable(R.color.white));
            }
        });



        show_select_theme();
        lock_theme();

        return frag;

    }



    public void lock_theme() {
        String status_lock = loadSettingString("status_lock", "0");
        if (status_lock.equals("unlocked")) {
            img_theme_2_unlock.setVisibility(View.GONE);
            img_theme_3_unlock.setVisibility(View.GONE);
            img_theme_4_unlock.setVisibility(View.GONE);
            img_theme_5_unlock.setVisibility(View.GONE);
            img_theme_6_unlock.setVisibility(View.GONE);
            img_theme_7_unlock.setVisibility(View.GONE);
            img_theme_8_unlock.setVisibility(View.GONE);
            img_theme_9_unlock.setVisibility(View.GONE);
            img_theme_10_unlock.setVisibility(View.GONE);
            img_theme_11_unlock.setVisibility(View.GONE);
            img_theme_12_unlock.setVisibility(View.GONE);

            // после исчезновения сообщения о блокировки, откроется сообщение что разблокировано
            cl_interior_theme_unlock.setVisibility(View.GONE);
            bt_unlocked_theme.setVisibility(View.GONE);
            tv_message_unblock_theme.setVisibility(View.VISIBLE);
        }
    }




// метод для того, чтобы когда я захожу в ll_theme, выбираю тему, выхожу и обратно захожу туда же, то выбранная тема была подсвечена, т.е. запомнена
    public void show_select_theme() {
        String show_select_theme = loadSettingString("i_choose_this_theme", "0");
        if(show_select_theme.equals("1")) {img_theme_1.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("2")) {img_theme_2.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("3")) {img_theme_3.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("4")) {img_theme_4.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("5")) {img_theme_5.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("6")) {img_theme_6.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("7")) {img_theme_7.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("8")) {img_theme_8.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("9")) {img_theme_9.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("10")) {img_theme_10.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("11")) {img_theme_11.setBackground(getResources().getDrawable(R.color.white));}
        if(show_select_theme.equals("12")) {img_theme_12.setBackground(getResources().getDrawable(R.color.white));}
    }


    // считывает файл
    public String loadSettingString(String key, String default_value) {
        // List_contact - имя файла, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_MULTI_PROCESS);
        return sharedPreferences.getString(key, default_value);
    }



// ТУТ С САМОГО НАЧАЛА СОЗДЕТСЯ ФАЙЛ sharedpreferences "select_theme"
    public void saveSettingString(String key, String value) {
        // List_contact - имя файла куда будут сохраняться данные, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = sharedPreferences.edit(); // edit() - редактирование файлов
        ed.putString(key, value); // добавляем ключ и его значение
        if (ed.commit()) // сохранить файл
        {
            //успешно записано данные в файл
        }
        else
        {
            //ошибка при записи
        }
    }




}
