package com.dev_marinov.xo;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.Context.MODE_MULTI_PROCESS;
import static android.content.Context.MODE_PRIVATE;


public class FragmentStatistica extends Fragment {

    View frag;

    SharedPreferences sharedPreferences;
    TextView tv_player_pc_person_0, tv_player_pc_person_x, tv_player_pc_android_x, tv_player_pc_android_0;
    TextView tv_game_1_1_X_left, tv_game_1_1_0_right;

    SwitchCompat switch_alert, switch_sound;
    Button bt_clear_game_player_pc, bt_clear_game_1_1;

    int sound_check = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        frag = inflater.inflate(R.layout.fragment_statistica, container, false);

        tv_player_pc_person_0 = frag.findViewById(R.id.tv_player_pc_person_0);
        tv_player_pc_person_x = frag.findViewById(R.id.tv_player_pc_person_x);
        tv_player_pc_android_x = frag.findViewById(R.id.tv_player_pc_android_x);
        tv_player_pc_android_0 = frag.findViewById(R.id.tv_player_pc_android_0);
        tv_game_1_1_X_left = frag.findViewById(R.id.tv_game_1_1_X_left);
        tv_game_1_1_0_right = frag.findViewById(R.id.tv_game_1_1_0_right);

        bt_clear_game_player_pc = frag.findViewById(R.id.bt_clear_game_player_pc);
        bt_clear_game_1_1 = frag.findViewById(R.id.bt_clear_game_1_1);

        switch_alert = frag.findViewById(R.id.switch_alert);
        switch_sound = frag.findViewById(R.id.switch_sound);


        // СЧЕТ ДЛЯ PLAYER | PC
        // выгрузка побед Х во fragment_statistica для GAME_PLAYER | PC
        String value_player_pc_person_0 = loadSettingString("player_pc_person_0", 0);
        tv_player_pc_person_0.setText(value_player_pc_person_0);
        String value_player_pc_person_x = loadSettingString("player_pc_person_x", 0);
        tv_player_pc_person_x.setText(value_player_pc_person_x);
        String value_player_pc_android_x = loadSettingString("player_pc_android_x", 0);
        tv_player_pc_android_x.setText(value_player_pc_android_x);
        String value_player_pc_android_0 = loadSettingString("player_pc_android_0", 0);
        tv_player_pc_android_0.setText(value_player_pc_android_0);

        // СЧЕТ ДЛЯ GAME_1_1
        // выгрузка побед Х во fragment_statistica для GAME_1_1
        String value_game_1_1_x = loadSettingString("game_1_1_x", 0);
        tv_game_1_1_X_left.setText(value_game_1_1_x);

        // запись побед 0 во fragment_statistica для GAME_1_1
        String value_game_1_1_0 = loadSettingString("game_1_1_0", 0);
        tv_game_1_1_0_right.setText(value_game_1_1_0);

        bt_clear_game_player_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSettingString("player_pc_person_0", 0);
                String value_player_pc_person_0 = loadSettingString("player_pc_person_0", 0);
                tv_player_pc_person_0.setText(value_player_pc_person_0);

                saveSettingString("player_pc_person_x", 0);
                String value_player_pc_person_x = loadSettingString("player_pc_person_x", 0);
                tv_player_pc_person_x.setText(value_player_pc_person_x);

                saveSettingString("player_pc_android_x", 0);
                String value_player_pc_android_x = loadSettingString("player_pc_android_x", 0);
                tv_player_pc_android_x.setText(value_player_pc_android_x);

                saveSettingString("player_pc_android_0", 0);
                String value_player_pc_android_0 = loadSettingString("player_pc_android_0", 0);
                tv_player_pc_android_0.setText(value_player_pc_android_0);
            }
        });
        bt_clear_game_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSettingString("game_1_1_x", 0);
                String value_game_1_1_x = loadSettingString("game_1_1_x", 0);
                tv_game_1_1_X_left.setText(value_game_1_1_x);

                saveSettingString("game_1_1_0", 0);
                String value_game_1_1_0 = loadSettingString("game_1_1_0", 0);
                tv_game_1_1_0_right.setText(value_game_1_1_0);
            }
        });

// изменение цвета switchCompat под мой стиль
        ColorStateList switchStates = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_checked},
                        new int[]{android.R.attr.state_enabled},
                        new int[]{}
                },
                new int[]{
                        Color.parseColor("#737065"), // выключить
                        Color.WHITE, // включить
                        Color.GREEN
                }
        );


        switch_alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_settings();

            }
        });
        switch_sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save_settings();
            }
        });

        switch_alert.getThumbDrawable().setTintList(switchStates);
        switch_alert.getTrackDrawable().setTintList(switchStates);
        switch_sound.getThumbDrawable().setTintList(switchStates);
        switch_sound.getTrackDrawable().setTintList(switchStates);

        return frag;
    }

    @Override
    public void onStop() {
        super.onStop();
        save_settings();
    }

    @Override
    public void onStart() {
        super.onStart();
        load_settings();
    }

    // метод для считывания состояния switch
    public void load_settings() {
        String alert_check = loadSettingString("alert_check", 0);
        if (alert_check.equals("0"))
        {
            switch_alert.setChecked(true);
        }
        else
        {
            switch_alert.setChecked(false);
        }

        String sound_check = loadSettingString("sound_check", 0);
        if (sound_check.equals("0"))
        {
            switch_sound.setChecked(true);
        }
        else
        {
            switch_sound.setChecked(false);
        }

    }

// метод для проверки состояния switch и сохранении его в sharedPref
    public void save_settings()
    {
        if (switch_alert.isChecked())
        {
            saveSettingString("alert_check", 0);
        }
        else
        {
            saveSettingString("alert_check", 1);
        }

        if (switch_sound.isChecked())
        {
            saveSettingString("sound_check", 0);
        }
        else
        {
            saveSettingString("sound_check", 1);
        }
    }


    // считывает файл РЕЗУЛЬАТЫ ПОБЕД
    public String loadSettingString(String key, int int_value) {
        // List_contact - имя файла, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_MULTI_PROCESS);
        return sharedPreferences.getString(key, String.valueOf(int_value));
    }

    // сохраняет в файл знаечния ноль, это очистка счетчиком
    public void saveSettingString(String key, int int_value) {
        // List_contact - имя файла куда будут сохраняться данные, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sharedPreferences.edit(); // edit() - редактирование файлов
        ed.putString(key, String.valueOf(int_value)); // добавляем ключ и его значение

        if (ed.commit()) // сохранить файл
        {
            //успешно записано данные в файл
        }
        else
        {
            //ошибка при записи
         //   Toast.makeText(getActivity(), "Write error", Toast.LENGTH_SHORT).show();
        }
    }











}
