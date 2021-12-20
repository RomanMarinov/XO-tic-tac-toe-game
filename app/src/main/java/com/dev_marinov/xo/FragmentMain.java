package com.dev_marinov.xo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

import static android.content.Context.MODE_MULTI_PROCESS;
import static android.content.Context.MODE_PRIVATE;

public class FragmentMain extends Fragment implements MainActivity.OnBackPressedListener{

    TextView text_test;

    AnimationDrawable animationDrawable_bt_game_online, animationDrawable_bt_player_pc, animationDrawable_bt_game_1_1;
    Animation anim;


    AudioManager audioManager;

    TextView tv_bt_1, tv_bt_2, tv_bt_3, tv_bt_4, tv_bt_5, tv_bt_6, tv_bt_7, tv_bt_8, tv_bt_9, tv_message_user, tv_startGame;
    ProgressBar progressBar;
    int number = 0;
    View frag;

    LinearLayout ll_conteiner_bt;
    LinearLayout ll_panel_loading;
    LinearLayout ll_est_sopernik;
    TextView tv_est_sopernik;
    String charGamer;
    String id_user1;
    String id_user2;
    String id_game;
    FrameLayout fr_ll_winner_line;

    LinearLayout ll_chet;

    ImageView img_first_step;
    Button bt_game_online;
    Button bt_player_pc;
    Button bt_game_1_1;
    GamePlayersPC_test textClass;

    // ПЕРЕМЕННЫЕ ДЛЯ ИГРЫ PLAYER PC
    String X0_player_pc;
    String XO_temp_player_pc;
    char ch_player_pc;
    String player_pc;
    String gamer_temp_player_pc;
    char char_gamer_player_pc;
    int winner_num_player_pc = 0;

    // ДЛЯ СЧЕТА ИГАРЫ ONLINE для user 1
    LinearLayout ll_main_user_1_block_left_game_online, ll_main_user_1_block_right_game_online;
    TextView tv_schet_user_1_left_person_1_x, tv_schet_user_1_left_person_2_0, tv_schet_user_1_right_person_2_x, tv_schet_user_1_right_person_1_0;
    TextView tv_tire_user_1_person_1_x, tv_tire_user_1_person_2_0, tv_tire_user_1_person_1_0, tv_tire_user_1_person_2_x;
    ImageView img_select_user_1_person_1_x, img_select_user_1_person_2_0, img_select_user_1_person_1_0, img_select_user_1_person_2_x;

    int count_schet_user_1_left_person_1_x = 0;
    int count_schet_user_1_left_person_2_0 = 0;
    int count_schet_user_1_right_person_1_0 = 0;
    int count_schet_user_1_right_person_2_x = 0;

////////// ДЛЯ СЧЕТА ИГАРЫ ONLINE для user 2 (соперник)
    LinearLayout ll_main_user_2_block_left_game_online, ll_main_user_2_block_right_game_online;
    TextView tv_schet_user_2_left_person_1_x, tv_schet_user_2_left_person_2_0, tv_schet_user_2_right_person_2_x, tv_schet_user_2_right_person_1_0;
    TextView tv_tire_user_2_person_1_x, tv_tire_user_2_person_2_0, tv_tire_user_2_person_1_0, tv_tire_user_2_person_2_x;
    ImageView img_select_user_2_person_1_x, img_select_user_2_person_2_0, img_select_user_2_person_1_0, img_select_user_2_person_2_x;

    int count_schet_user_2_left_person_1_x = 0;
    int count_schet_user_2_left_person_2_0 = 0;
    int count_schet_user_2_right_person_1_0 = 0;
    int count_schet_user_2_right_person_2_x = 0;






    // ДЛЯ СЧЕТА КТО ЗА КОГО ИГРАЕТ НА ПЕРЕДНЕЙ ПАНЕЛИ ДЛЯ ИГРЫ PLAYER PC
    LinearLayout ll_main_block_left_player_pc, ll_main_block_right_player_pc, ll_main_main_block_player_pc;
    TextView tv_schet_left_1_x, tv_schet_left_2_0, tv_schet_right_1_0, tv_schet_right_2_x;
    TextView tv_tire_1_0, tv_tire_2_x, tv_tire_1_x, tv_tire_2_0;
    ImageView img_select_nolik_1, img_select_krestik_2, img_select_nolik_2, img_select_krestik_1;
    LinearLayout ll_block_left_1_x, ll_block_left_2_0;
    LinearLayout ll_block_right_2_x, ll_block_right_1_0;
    int count_player_pc_left_1_x = 0;
    int count_player_pc_left_2_0 = 0;
    int count_player_pc_right_1_0 = 0;
    int count_player_pc_right_2_x = 0;

    // ПЕРЕМЕННЫЕ ДЛЯ ИГРЫ GAME 1 | 1
    String X0_game_1_1;
    String XO_temp_game_1_1;
    char ch_game_1_1;
    TextView tv_schet_left_game_1_1, tv_schet_right_game_1_1;
    LinearLayout ll_main_block_game_1_1;
    int count_game_1_1_left_x = 0;
    int count_game_1_1_right_0 = 0;
    int winner_num_game_1_1 = 0;

    boolean bool_status_click_game_1_1_on = false;

    // ДЛЯ АНИМАЦИИ
    ImageView img_projector_screen;
    ImageView img_black_osnovanie;
    FrameLayout fr_ll_projector_screen;

    TextView tv_projector_screen, tv_projector_screen_2;
    LinearLayout super_ll_screen_animation;

    ImageView img_projector_XO, img_projector_XO_2;
    MediaPlayer song_cherta, song_krestik, song_nolik;
    MediaPlayer song_theme_2_nolik, song_theme_2_krest, song_theme_2_win;
    MediaPlayer song_theme_3_nolik, song_theme_3_krest, song_theme_3_win;
    MediaPlayer song_theme_4_nolik, song_theme_4_krest;
    MediaPlayer song_theme_5_nolik, song_theme_5_krest;
    MediaPlayer song_theme_6_nolik, song_theme_6_krest;
    MediaPlayer song_theme_7_nolik, song_theme_7_krest;
    MediaPlayer song_theme_8_nolik, song_theme_8_krest;
    MediaPlayer song_theme_9_nolik, song_theme_9_krest;
    MediaPlayer song_theme_10_nolik, song_theme_10_krest, song_theme_10_win;
    MediaPlayer song_theme_11_nolik, song_theme_11_krest;
    MediaPlayer song_theme_12_nolik, song_theme_12_krest;

    LinearLayout ll_theme, ll_statistica, ll_share;

    SharedPreferences sharedPreferences;
    String temp_theme;
    Boolean voobsheto_tak;
    String this_game = "";

    Timer tim;
    String id_user_free = "";

    ////////////////////////////////////////////////////
    // МЕТОДЫ ОБЩИЕ ВСЕХ ИГР
    public void clear_tv_bt_all() { // метод очищает содержимое textview
        tv_bt_1.setText("");
        tv_bt_2.setText("");
        tv_bt_3.setText("");
        tv_bt_4.setText("");
        tv_bt_5.setText("");
        tv_bt_6.setText("");
        tv_bt_7.setText("");
        tv_bt_8.setText("");
        tv_bt_9.setText("");
    }

    public void clear_tv_background_all() { // метод удаляет картинку крестика и нолика
        tv_bt_1.setBackground(null);
        tv_bt_2.setBackground(null);
        tv_bt_3.setBackground(null);
        tv_bt_4.setBackground(null);
        tv_bt_5.setBackground(null);
        tv_bt_6.setBackground(null);
        tv_bt_7.setBackground(null);
        tv_bt_8.setBackground(null);
        tv_bt_9.setBackground(null);

        fr_ll_winner_line.setBackground(null);
    }

    public void delay_clear_tv_background_all() { // метод удаляет картинку крестика и нолика с ЗАДЕРЖКОЙ
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                clear_tv_background_all();
            }
        }, 1100);
    }


    public void close_tv_bt_all() { // метод для блокировки всех tv_bt при "Ожидание хода соперника..."
        tv_bt_1.setEnabled(false);
        tv_bt_2.setEnabled(false);
        tv_bt_3.setEnabled(false);
        tv_bt_4.setEnabled(false);
        tv_bt_5.setEnabled(false);
        tv_bt_6.setEnabled(false);
        tv_bt_7.setEnabled(false);
        tv_bt_8.setEnabled(false);
        tv_bt_9.setEnabled(false);
    }

    public void open_tv_bt_all() { // метод для снятия блокировки всех tv_bt при "Ожидание хода соперника..."
        tv_bt_1.setEnabled(true);
        tv_bt_2.setEnabled(true);
        tv_bt_3.setEnabled(true);
        tv_bt_4.setEnabled(true);
        tv_bt_5.setEnabled(true);
        tv_bt_6.setEnabled(true);
        tv_bt_7.setEnabled(true);
        tv_bt_8.setEnabled(true);
        tv_bt_9.setEnabled(true);
    }


    public void animation() {

        fr_ll_projector_screen.setVisibility(View.VISIBLE); // открытие фрейм лэйаута в котором находиться

        // анимация для черного основания из которого вылетает холст img_projector_screen
        Animation black_osnovanie_Animation = AnimationUtils.loadAnimation(getActivity(), R.anim.black_osnovanie_animation);
        img_black_osnovanie.setVisibility(View.VISIBLE);
        img_black_osnovanie.startAnimation(black_osnovanie_Animation);

        // анимация холста img_projector_screen
        Animation projector_screen_Animation = AnimationUtils.loadAnimation(getActivity(), R.anim.projector_screen_animation);
        img_projector_screen.setVisibility(View.VISIBLE);
        img_projector_screen.startAnimation(projector_screen_Animation);

        // анимация контейнера с двумя textview и двумя imageview, который находиться в холсте
        Animation super_ll_screen_animation_Animation = AnimationUtils.loadAnimation(getActivity(), R.anim.super_ll_screen_animation);
        super_ll_screen_animation.setVisibility(View.VISIBLE);
        super_ll_screen_animation.startAnimation(super_ll_screen_animation_Animation);

        tv_projector_screen.setVisibility(View.VISIBLE); // показ верхнего textview
        tv_projector_screen_2.setVisibility(View.VISIBLE); // показ нижнего textview

        clear_tv_bt_all();
        clear_tv_background_all();
        delay_clear_tv_background_all();
        open_tv_bt_all();

    }

    public void delay_animation() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                animation();
            }
        }, 1000); // задержка выполнения кода на 1 сек
    }


    public void close_tv_bt() {  // метод для блокировки некоторых tv_bt при "Ваш ход..."
        if (!tv_bt_1.getText().equals("")) { tv_bt_1.setEnabled(false);
        } else {
            tv_bt_1.setEnabled(true);
        }
        if (!tv_bt_2.getText().equals("")) { tv_bt_2.setEnabled(false);
        } else {
            tv_bt_2.setEnabled(true);
        }
        if (!tv_bt_3.getText().equals("")) { tv_bt_3.setEnabled(false);
        } else {
            tv_bt_3.setEnabled(true);
        }
        if (!tv_bt_4.getText().equals("")) { tv_bt_4.setEnabled(false);
        } else {
            tv_bt_4.setEnabled(true);
        }
        if (!tv_bt_5.getText().equals("")) { tv_bt_5.setEnabled(false);
        } else {
            tv_bt_5.setEnabled(true);
        }
        if (!tv_bt_6.getText().equals("")) { tv_bt_6.setEnabled(false);
        } else {
            tv_bt_6.setEnabled(true);
        }
        if (!tv_bt_7.getText().equals("")) { tv_bt_7.setEnabled(false);
        } else {
            tv_bt_7.setEnabled(true);
        }
        if (!tv_bt_8.getText().equals("")) { tv_bt_8.setEnabled(false);
        } else {
            tv_bt_8.setEnabled(true);
        }
        if (!tv_bt_9.getText().equals("")) { tv_bt_9.setEnabled(false);
        } else {
            tv_bt_9.setEnabled(true);
        }
    }

// метод включения кликабельности кнопок
    public void set_click_enabled()
    {
        tv_bt_1.setClickable(true);
        tv_bt_2.setClickable(true);
        tv_bt_3.setClickable(true);
        tv_bt_4.setClickable(true);
        tv_bt_5.setClickable(true);
        tv_bt_6.setClickable(true);
        tv_bt_7.setClickable(true);
        tv_bt_8.setClickable(true);
        tv_bt_9.setClickable(true);
    }
    // метод выключения кликабельности кнопок
    public void set_click_disabled()
    {
        tv_bt_1.setClickable(false);
        tv_bt_2.setClickable(false);
        tv_bt_3.setClickable(false);
        tv_bt_4.setClickable(false);
        tv_bt_5.setClickable(false);
        tv_bt_6.setClickable(false);
        tv_bt_7.setClickable(false);
        tv_bt_8.setClickable(false);
        tv_bt_9.setClickable(false);
    }


    // методы с смены темы поля игры с реальном времени
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).setOnBackPressedListener(this);
    }

    @Override
    public void doBack() {
        //BackPressed in activity will call this;
        select_theme();
        //schet_game_online();
        schet_game_player_pc();
        schet_game_1_1();

        voobsheto_tak();

        update_image_for_theme_game_1_1();

        update_image_for_theme_top_game_online_X();
        update_image_for_theme_top_game_online_0();

        sound_stop();

      //  est_sopernik_blink();
    }

    public void voobsheto_tak() {
        try {
            if (!voobsheto_tak || this_game.equals(null)) { // если false  и тогда return то анимация не будет работать
            return;
            }
            if (this_game.equals("game_online")) {
                animation();
                game_online();
            }
            if (this_game.equals("game_player_pc")) {
                animation();
                game_player_pc();
            }
            if (this_game.equals("game_1_1")) {
                animation();
                game_1_1();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select_theme() {
        temp_theme = loadSettingString("i_choose_this_theme", "0");

        if (this_game.equals(""))
        {
            img_first_step.setVisibility(View.GONE);
        }

        if (temp_theme.equals("1")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_1_doska_1000_1000)); }
        if (temp_theme.equals("2")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_2_pole)); }
        if (temp_theme.equals("3")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_3_vpp)); }
        if (temp_theme.equals("4")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_4_doska_bambuk)); }
        if (temp_theme.equals("5")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_5_polotno)); }
        if (temp_theme.equals("6")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_6_stena)); }
        if (temp_theme.equals("7")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_7_doska)); }
        if (temp_theme.equals("8")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_8_pesok)); }
        if (temp_theme.equals("9")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_9_fon)); }
        if (temp_theme.equals("10")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_10_paper)); }
        if (temp_theme.equals("11")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_11_kosmos)); }
        if (temp_theme.equals("12")) { ll_conteiner_bt.setBackground(getResources().getDrawable(R.drawable.theme_12_pole)); }
    }

    public void update_image_for_theme_game_1_1()
    {
        if (temp_theme.equals("1"))
        {

            if (this_game.equals("game_1_1")) {
            if (XO_temp_game_1_1.equals("X")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (XO_temp_game_1_1.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik));}
            }

            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); }
        }
        if (temp_theme.equals("2"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
        }
        if (temp_theme.equals("3"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
        }
        if (temp_theme.equals("4"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
        }
        if (temp_theme.equals("5"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
        }
        if (temp_theme.equals("6"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
        }
        if (temp_theme.equals("7"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
        }
        if (temp_theme.equals("8"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
        }
        if (temp_theme.equals("9"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
        }
        if (temp_theme.equals("10"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
        }
        if (temp_theme.equals("11"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
        }
        if (temp_theme.equals("12"))
        {
            if (this_game.equals("game_1_1")) {
                if (XO_temp_game_1_1.equals("X")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
                if (XO_temp_game_1_1.equals("0")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            }
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
        }
    }








    // считывает файл
    public String loadSettingString(String key, String default_value) {
        // List_contact - имя файла, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_MULTI_PROCESS);
        return sharedPreferences.getString(key, default_value);
    }

    // СНАЧАЛА ТУТ СОЗДЕТСЯ ФАЙЛ SharedPreferences "List_contact" в который записывается все остальное
    // сохраняет в файл
    public void saveSettingString(String key, int int_value) {
        // List_contact - имя файла куда будут сохраняться данные, MODE_MULTI_PROCESS - доступ для всех процессов
        sharedPreferences = getActivity().getSharedPreferences("myPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit(); // edit() - редактирование файлов
        editor.putString(key, String.valueOf(int_value)); // добавляем ключ и его значение
        if (editor.commit()) // сохранить файл
        {
            //успешно записано данные в файл
        }
        else
        {
          //  Toast.makeText(getActivity(), "Write error", Toast.LENGTH_SHORT).show(); //ошибка при записи
        }
    }
    // МЕТОДЫ ОБЩИЕ ВСЕХ ИГР
    ///////////////////////////////////////////////////////






























    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        frag =  inflater.inflate(R.layout.fragment_main, container, false);



//          textClass = new GamePlayersPC_test(frag.getContext(),"test","test");
//
//
//        textClass.setOnGet(new GamePlayersPC_test.onGetXod() {
//            @Override
//            public void onGetXod(int par1,String id) {
//
//                // срабатывает когда класс game player что выполнил
//                Log.e("test_xod","result="+par1);
//            }
//        });
//
//
//        tv_bt_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                textClass.xod(1,2,"X");
//            }
//        });





        ConstraintLayout constraintLayout = frag.findViewById(R.id.cl_main);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(1500);
        animationDrawable.setExitFadeDuration(3000);
        animationDrawable.start();







//          вывести id_user_free для проверки
//        text_test= frag.findViewById(R.id.text_test);
//
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        text_test.setText("="+id_user_free);
//                    }
//                });
//            }
//        }, 1000,1000);




        tv_bt_1 = frag.findViewById(R.id.tv_bt_1);
        tv_bt_2 = frag.findViewById(R.id.tv_bt_2);
        tv_bt_3 = frag.findViewById(R.id.tv_bt_3);
        tv_bt_4 = frag.findViewById(R.id.tv_bt_4);
        tv_bt_5 = frag.findViewById(R.id.tv_bt_5);
        tv_bt_6 = frag.findViewById(R.id.tv_bt_6);
        tv_bt_7 = frag.findViewById(R.id.tv_bt_7);
        tv_bt_8 = frag.findViewById(R.id.tv_bt_8);
        tv_bt_9 = frag.findViewById(R.id.tv_bt_9);
        tv_message_user = frag.findViewById(R.id.tv_message_user);
        tv_startGame = frag.findViewById(R.id.tv_startGame);
        ll_panel_loading = frag.findViewById(R.id.ll_panel_loading);
        ll_conteiner_bt = frag.findViewById(R.id.ll_conteiner_bt);
        ll_est_sopernik = frag.findViewById(R.id.ll_est_sopernik);
        tv_est_sopernik = frag.findViewById(R.id.tv_est_sopernik);

        progressBar = frag.findViewById(R.id.progressBar);

        fr_ll_winner_line = frag.findViewById(R.id.fr_ll_winner_line);

        img_first_step = frag.findViewById(R.id.img_first_step);


        ll_chet = frag.findViewById(R.id.ll_chet);

        bt_game_online = frag.findViewById(R.id.bt_game_online);
        bt_player_pc = frag.findViewById(R.id.bt_player_pc);
        bt_game_1_1 = frag.findViewById(R.id.bt_game_1_1);

        tv_schet_left_1_x = frag.findViewById(R.id.tv_schet_left_1_x);
        tv_schet_left_2_0 = frag.findViewById(R.id.tv_schet_left_2_0);
        tv_schet_right_1_0 = frag.findViewById(R.id.tv_schet_right_1_0);
        tv_schet_right_2_x = frag.findViewById(R.id.tv_schet_right_2_x);
        tv_tire_1_0 = frag.findViewById(R.id.tv_tire_1_0);
        tv_tire_2_x = frag.findViewById(R.id.tv_tire_2_x);
        tv_tire_1_x = frag.findViewById(R.id.tv_tire_1_x);
        tv_tire_2_0 = frag.findViewById(R.id.tv_tire_2_0);
        img_select_krestik_1 = frag.findViewById(R.id.img_select_krestik_1);
        img_select_krestik_2 = frag.findViewById(R.id.img_select_krestik_2);
        img_select_nolik_1 = frag.findViewById(R.id.img_select_nolik_1);
        img_select_nolik_2 = frag.findViewById(R.id.img_select_nolik_2);

        fr_ll_projector_screen = frag.findViewById(R.id.fr_ll_projector_screen);
        img_black_osnovanie = frag.findViewById(R.id.img_black_osnovanie);
        img_projector_screen = frag.findViewById(R.id.img_projector_screen);

        tv_projector_screen = frag.findViewById(R.id.tv_projector_screen);
        tv_projector_screen_2 = frag.findViewById(R.id.tv_projector_screen_2);


// контейнеры игры game_online
//        ll_main_user_1_block_left_game_online = frag.findViewById(R.id.ll_main_user_1_block_left_game_online);
//        ll_main_user_1_block_right_game_online = frag.findViewById(R.id.ll_main_user_1_block_right_game_online);
//
//        tv_schet_user_1_left_person_1_x = frag.findViewById(R.id.tv_schet_user_1_left_person_1_x);
//        tv_schet_user_1_left_person_2_0 = frag.findViewById(R.id.tv_schet_user_1_left_person_2_0);
//        tv_schet_user_1_right_person_1_0 = frag.findViewById(R.id.tv_schet_user_1_right_person_1_0);
//        tv_schet_user_1_right_person_2_x = frag.findViewById(R.id.tv_schet_user_1_right_person_2_x);
//
//        tv_tire_user_1_person_1_x = frag.findViewById(R.id.tv_tire_user_1_person_1_x);
//        tv_tire_user_1_person_2_0 = frag.findViewById(R.id.tv_tire_user_1_person_2_0);
//        tv_tire_user_1_person_1_0 = frag.findViewById(R.id.tv_tire_user_1_person_1_0);
//        tv_tire_user_1_person_2_x = frag.findViewById(R.id.tv_tire_user_1_person_2_x);
//
//        img_select_user_1_person_1_x = frag.findViewById(R.id.img_select_user_1_person_1_x);
//        img_select_user_1_person_2_0 = frag.findViewById(R.id.img_select_user_1_person_2_0);
//        img_select_user_1_person_1_0 = frag.findViewById(R.id.img_select_user_1_person_1_0);
//        img_select_user_1_person_2_x = frag.findViewById(R.id.img_select_user_1_person_2_x);
//        //////////////////////////////////////
//        ll_main_user_2_block_left_game_online = frag.findViewById(R.id.ll_main_user_2_block_left_game_online);
//        ll_main_user_2_block_right_game_online = frag.findViewById(R.id.ll_main_user_2_block_right_game_online);
//
//        tv_schet_user_2_left_person_1_x = frag.findViewById(R.id.tv_schet_user_2_left_person_1_x);
//        tv_schet_user_2_left_person_2_0 = frag.findViewById(R.id.tv_schet_user_2_left_person_2_0);
//        tv_schet_user_2_right_person_1_0 = frag.findViewById(R.id.tv_schet_user_2_right_person_1_0);
//        tv_schet_user_2_right_person_2_x = frag.findViewById(R.id.tv_schet_user_2_right_person_2_x);
//
//        tv_tire_user_2_person_1_x = frag.findViewById(R.id.tv_tire_user_2_person_1_x);
//        tv_tire_user_2_person_2_0 = frag.findViewById(R.id.tv_tire_user_2_person_2_0);
//        tv_tire_user_2_person_1_0 = frag.findViewById(R.id.tv_tire_user_2_person_1_0);
//        tv_tire_user_2_person_2_x = frag.findViewById(R.id.tv_tire_user_2_person_2_x);
//
//        img_select_user_2_person_1_x = frag.findViewById(R.id.img_select_user_2_person_1_x);
//        img_select_user_2_person_2_0 = frag.findViewById(R.id.img_select_user_2_person_2_0);
//        img_select_user_2_person_1_0 = frag.findViewById(R.id.img_select_user_2_person_1_0);
//        img_select_user_2_person_2_x = frag.findViewById(R.id.img_select_user_2_person_2_x);

// контейнеры игры player_pc
        ll_main_block_left_player_pc = frag.findViewById(R.id.ll_main_block_left_player_pc);
        ll_main_block_right_player_pc = frag.findViewById(R.id.ll_main_block_right_player_pc);
        ll_main_main_block_player_pc = frag.findViewById(R.id.ll_main_main_block_player_pc);

        ll_block_left_1_x = frag.findViewById(R.id.ll_block_left_1_x);
        ll_block_left_2_0 = frag.findViewById(R.id.ll_block_left_2_0);
        ll_block_right_1_0 = frag.findViewById(R.id.ll_block_right_1_0);
        ll_block_right_2_x = frag.findViewById(R.id.ll_block_right_2_x);

// контейнеры игры game
        ll_main_block_game_1_1 = frag.findViewById(R.id.ll_main_block_game_1_1);
        tv_schet_left_game_1_1 = frag.findViewById(R.id.tv_schet_left_game_1_1);
        tv_schet_right_game_1_1 = frag.findViewById(R.id.tv_schet_right_game_1_1);

        img_projector_XO = frag.findViewById(R.id.img_projector_XO);
        img_projector_XO_2 = frag.findViewById(R.id.img_projector_XO_2);
        super_ll_screen_animation = frag.findViewById(R.id.super_ll_screen_animation);

        song_cherta = MediaPlayer.create(getActivity(), R.raw.chertawin);
        song_krestik = MediaPlayer.create(getActivity(), R.raw.krestik);
        song_nolik = MediaPlayer.create(getActivity(), R.raw.nolik);

        song_theme_2_nolik = MediaPlayer.create(getActivity(), R.raw.theme_2_ball);
        song_theme_2_krest = MediaPlayer.create(getActivity(), R.raw.theme_2_flajki);
        song_theme_2_win = MediaPlayer.create(getActivity(), R.raw.theme_2_win);
        song_theme_3_nolik = MediaPlayer.create(getActivity(), R.raw.theme_3_turbina);
        song_theme_3_krest = MediaPlayer.create(getActivity(), R.raw.theme_3_lopasti);
        song_theme_3_win = MediaPlayer.create(getActivity(), R.raw.theme_3_samolet);
        song_theme_4_nolik = MediaPlayer.create(getActivity(), R.raw.theme_4_roll);
        song_theme_4_krest = MediaPlayer.create(getActivity(), R.raw.theme_4_suchi);
        song_theme_5_nolik = MediaPlayer.create(getActivity(), R.raw.theme_5_in_yan);
        song_theme_5_krest = MediaPlayer.create(getActivity(), R.raw.theme_5_krest);
        song_theme_6_nolik = MediaPlayer.create(getActivity(), R.raw.theme_6_shit);
        song_theme_6_krest = MediaPlayer.create(getActivity(), R.raw.theme_6_mech);
        song_theme_7_nolik = MediaPlayer.create(getActivity(), R.raw.theme_7_sir);
        song_theme_7_krest = MediaPlayer.create(getActivity(), R.raw.theme_7_knife);
        song_theme_8_nolik = MediaPlayer.create(getActivity(), R.raw.theme_8_koleso);
        song_theme_8_krest = MediaPlayer.create(getActivity(), R.raw.theme_8_prujina);
        song_theme_9_nolik = MediaPlayer.create(getActivity(), R.raw.theme_9_pig);
        song_theme_9_krest = MediaPlayer.create(getActivity(), R.raw.theme_9_molotok);
        song_theme_10_nolik = MediaPlayer.create(getActivity(), R.raw.theme_10_burger);
        song_theme_10_krest = MediaPlayer.create(getActivity(), R.raw.theme_10_hotdog);
        song_theme_10_win = MediaPlayer.create(getActivity(), R.raw.theme_10_winner);
        song_theme_11_nolik = MediaPlayer.create(getActivity(), R.raw.theme_11_planeta);
        song_theme_11_krest = MediaPlayer.create(getActivity(), R.raw.theme_11_raketa);
        song_theme_12_nolik = MediaPlayer.create(getActivity(), R.raw.theme_12_face);
        song_theme_12_krest = MediaPlayer.create(getActivity(), R.raw.theme_12_nojnitsi);

        ll_theme = frag.findViewById(R.id.ll_theme);
        ll_statistica = frag.findViewById(R.id.ll_statistica);
        ll_share = frag.findViewById(R.id.ll_share);


/////////////////////////////////////////
        // КНОПКА ВЫБОРА ИГРЫ GAME ONLINE

        bt_game_online.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

             //       Toast.makeText(getContext(), "id_user_free = " + id_user_free, Toast.LENGTH_LONG).show();

                if (!id_user_free.equals("")) //Если еть приглашение, то начинаем играть с тем кто пригласил - id_user_free - ссылка на "кто пригласил"
                {
                   Log.e("free","id_user_free=" + id_user_free);
                    Gson json = new Gson();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("cmd", "start_game_free");
                    hashMap.put("id_user_free", id_user_free);
                    String json_string = json.toJson(hashMap);
                    ((MainActivity) getActivity()).clws.send(json_string);
                    Log.e("free","start_game_free=");
                    id_user_free = "";
                }
                else {
                //    Toast.makeText(getContext(), " = " + id_user_free, Toast.LENGTH_LONG).show();
                    voobsheto_tak = true;
                    tv_startGame.setVisibility(View.VISIBLE);
                    tv_startGame.setText(getResources().getString(R.string.waiting));
                    progressBar.setVisibility(View.VISIBLE);
                    close_tv_bt_all();
                    set_click_disabled();
                    // open_tv_bt_all();

                    Log.e("free","id_user_free=" + id_user_free);
                    Gson json = new Gson();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("cmd", "start_game_online");
                    String json_string = json.toJson(hashMap);
// когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
                    ((MainActivity) getActivity()).clws.send(json_string);

//                    // отправка json для рассылки готовности играть онлайн всем пользователям
//                    Gson json_mail = new Gson();
//                    HashMap<String, Object> hashMap_mail = new HashMap<>();
//                    hashMap_mail.put("cmd", "free_player_appeared");
//                    String json_string_mail = json_mail.toJson(hashMap_mail);
//                    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
//                    ((MainActivity) getActivity()).clws.send(json_string_mail);


                    Log.e("free","start_game_online и free_player_appeared");
                }

                    this_game = "game_online";
                    //     Toast.makeText(getContext(), "bt_game_online НА ВЫХОДЕ GAME_ONLINE = " + this_game, Toast.LENGTH_LONG).show();

                    ll_panel_loading.setVisibility(View.VISIBLE);

                    // выделение кнопки при нажатии (вокруг кнопки появляется белый контур)
                    bt_game_online.setBackground(getResources().getDrawable(R.drawable.button_border));
                    // снятие выделения с кнопок bt_game_1_1 и bt_player_pc
                    bt_game_1_1.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));
                    bt_player_pc.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));

                ll_main_main_block_player_pc.setVisibility(View.GONE);
                    ll_main_block_left_player_pc.setVisibility(View.GONE); // скрыть контейнеры с счетчиками для игры player_pc
                    ll_main_block_right_player_pc.setVisibility(View.GONE);
                    ll_main_block_game_1_1.setVisibility(View.GONE); // скрыть контейнеры с счетчиками для игры game_1_1
//                ll_main_user_1_block_left_game_online.setVisibility(View.GONE); //  скрыть контейнеры игры online
//                ll_main_user_1_block_right_game_online.setVisibility(View.GONE);

                    img_projector_XO.setVisibility(View.GONE); // скрыть сообщение победы (картинки)

                    // специально пусто для создания пустового пространства при нажатии bt_player_pc
                    tv_message_user.setText("");
                    img_first_step.setBackground(null);
            }
        });



///////////////////////////////////////////////////
        // КНОПКА ВЫБОРА ИГРЫ PLAYER / PC
        bt_player_pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Gson json = new Gson();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("cmd", "stop_game");
                    String json_string = json.toJson(hashMap);
                    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
                    ((MainActivity) getActivity()).clws.send(json_string);

                    ((MainActivity)getActivity()).clws.disconnect();// разрыв соединения с сервером на некоторое время


                this_game = "game_player_pc";

                voobsheto_tak = true;

                tv_projector_screen_2.setText("");
                tv_startGame.setVisibility(View.GONE);
                progressBar.setVisibility(View.GONE);

                bt_player_pc.setBackground(getResources().getDrawable(R.drawable.button_border)); // выделение кнопки по контуру при нажатии
                // снятие с кнопки выделения по контуру при нажатии на bt_player_pc
                bt_game_1_1.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));
                bt_game_online.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));

                ll_main_main_block_player_pc.setVisibility(View.VISIBLE);
                ll_main_block_left_player_pc.setVisibility(View.VISIBLE); // показать контейнеры с счетчиками для игры player_pc
                ll_main_block_right_player_pc.setVisibility(View.VISIBLE);

//                ll_main_user_1_block_left_game_online.setVisibility(View.GONE); //  скрыть контейнеры игры online
//                ll_main_user_1_block_right_game_online.setVisibility(View.GONE);
                ll_main_block_game_1_1.setVisibility(View.GONE); // скрыть контейнеры с счетчиками для игры game_1_1
                img_projector_XO.setVisibility(View.GONE); // скрыть сообщение победы (картинки)

                // специально пусто для создания пустового пространства при нажатии bt_player_pc
                tv_message_user.setText("");
                img_first_step.setBackground(null);


                delay_animation();


                if (tv_schet_left_1_x.getText().equals("0") &
                    tv_schet_left_2_0.getText().equals("0") &
                    tv_schet_right_1_0.getText().equals("0") &
                    tv_schet_right_2_x.getText().equals("0")) {
                tv_projector_screen.setText(getResources().getString(R.string.game_player_pc));

                    if (!tv_bt_1.getText().equals("") |
                            !tv_bt_2.getText().equals("") |
                            !tv_bt_3.getText().equals("") |
                            !tv_bt_4.getText().equals("") |
                            !tv_bt_5.getText().equals("") |
                            !tv_bt_6.getText().equals("") |
                            !tv_bt_7.getText().equals("") |
                            !tv_bt_8.getText().equals("") |
                            !tv_bt_9.getText().equals("")) {
                        tv_projector_screen_2.setText(getResources().getString(R.string.current_deleted));

                    }
                }
                else {
                    tv_projector_screen.setText(getResources().getString(R.string.continue_game_player_pc));

                    if (!tv_bt_1.getText().equals("") |
                            !tv_bt_2.getText().equals("") |
                            !tv_bt_3.getText().equals("") |
                            !tv_bt_4.getText().equals("") |
                            !tv_bt_5.getText().equals("") |
                            !tv_bt_6.getText().equals("") |
                            !tv_bt_7.getText().equals("") |
                            !tv_bt_8.getText().equals("") |
                            !tv_bt_9.getText().equals("")) {
                        tv_projector_screen_2.setText(getResources().getString(R.string.current_deleted));
                    }
                }

                // запихнуть задержку
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        game_player_pc();
                    }
                }, 3000); // задержка выполнения кода на 1 сек
            }
        });


        // КНОПКА ВЫБОРА ИГРЫ 1/1
        bt_game_1_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Gson json = new Gson();
                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("cmd", "stop_game");
                    String json_string = json.toJson(hashMap);
                    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
                    ((MainActivity) getActivity()).clws.send(json_string);

                    ((MainActivity) getActivity()).clws.disconnect();

                this_game = "game_1_1";

              //  Toast.makeText(getContext(), "bt_game_1_1 НА ВЫХОДЕ GAME_1_1 = " + this_game, Toast.LENGTH_LONG).show();

                voobsheto_tak = true;
                tv_projector_screen_2.setText("");
                progressBar.setVisibility(View.GONE);
                tv_startGame.setVisibility(View.GONE);

                bt_game_1_1.setBackground(getResources().getDrawable(R.drawable.button_border)); // при нажатии кнопки происходит выделение
                // снятие выделения с двух других игр
                bt_game_online.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));
                bt_player_pc.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));

//                ll_main_user_1_block_left_game_online.setVisibility(View.GONE); //  скрыть контейнеры игры online
//                ll_main_user_1_block_right_game_online.setVisibility(View.GONE);
                ll_main_main_block_player_pc.setVisibility(View.GONE);
                ll_main_block_left_player_pc.setVisibility(View.GONE); // скрыть контейнеры с счетчиками
                ll_main_block_right_player_pc.setVisibility(View.GONE);

                ll_main_block_game_1_1.setVisibility(View.VISIBLE); // показать контейнер с счетчиком для игры game_1_1
                img_projector_XO.setVisibility(View.GONE); // скрыть сообщение победы (картинки)

                // специально пусто для создания пустового пространства при нажатии bt_1_1
                tv_message_user.setText("");
                img_first_step.setBackground(null);

                delay_animation();
                // снятие с кнопки выделения по контуру при нажатии на bt_1_1
                bt_player_pc.setBackground(getResources().getDrawable(R.drawable.gradient_button_game));
                img_projector_XO.setVisibility(View.GONE);
                img_projector_XO_2.setVisibility(View.GONE);

                // если игрок не удалил свой счет игры game_1_1 и зашел в нее после после перезагрузки приложения
                if (tv_schet_left_game_1_1.getText().equals("0") & tv_schet_right_game_1_1.getText().equals("0")) {

                    tv_projector_screen.setText(getResources().getString(R.string.game_1_1));

                    if (!tv_bt_1.getText().equals("") |
                            !tv_bt_2.getText().equals("") |
                            !tv_bt_3.getText().equals("") |
                            !tv_bt_4.getText().equals("") |
                            !tv_bt_5.getText().equals("") |
                            !tv_bt_6.getText().equals("") |
                            !tv_bt_7.getText().equals("") |
                            !tv_bt_8.getText().equals("") |
                            !tv_bt_9.getText().equals("")) {
                                tv_projector_screen_2.setText(getResources().getString(R.string.current_deleted));
                            }
                        }

                else {
                    tv_projector_screen.setText(getResources().getString(R.string.continue_game_1_1));

                    if (!tv_bt_1.getText().equals("") |
                            !tv_bt_2.getText().equals("") |
                            !tv_bt_3.getText().equals("") |
                            !tv_bt_4.getText().equals("") |
                            !tv_bt_5.getText().equals("") |
                            !tv_bt_6.getText().equals("") |
                            !tv_bt_7.getText().equals("") |
                            !tv_bt_8.getText().equals("") |
                            !tv_bt_9.getText().equals("")) {
                        tv_projector_screen_2.setText(getResources().getString(R.string.current_deleted));
                    }
                }
                // запихнуть задержку
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        game_1_1();
                    }
                }, 3000); // задержка выполнения кода на 1 сек

            }
        });



        // КОНТЕЙНЕР ДЛЯ ПЕРЕХОДА ВО FRAGMENT_THEME ВЫБОР ТЕМ
        ll_theme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(getContext(), "НАЖАЛ НА ВЫБОР ТЕМЫ = ", Toast.LENGTH_LONG).show();


                voobsheto_tak = false; // чтобы при выходе из fragment_theme при выборе другой темы срабатывала анимация

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentTheme fragmentTheme = new FragmentTheme();
                fragmentTransaction.replace(R.id.ll_frag_theme, fragmentTheme);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                ((MainActivity)getActivity()).ll_frag_theme.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).ll_frag_statistica.setVisibility(View.GONE);

            }
        });

        // КОНТЕЙНЕР ДЛЯ ПЕРЕХОДА ВО FRAGMENT_STATISTICA
        ll_statistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // Toast.makeText(getContext(), "НАЖАЛ НА ВЫБОР СТАТИСТИКИ = ", Toast.LENGTH_LONG).show();

                voobsheto_tak = false; // чтобы при выходе из ll_statistica при выборе другой темы срабатывала анимация

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentStatistica fragmentStatistica = new FragmentStatistica();
                fragmentTransaction.replace(R.id.ll_frag_statistica, fragmentStatistica);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                ((MainActivity)getActivity()).ll_frag_statistica.setVisibility(View.VISIBLE);
                ((MainActivity)getActivity()).ll_frag_theme.setVisibility(View.GONE);
            }
        });

        // КОНТЕЙНЕР ДЛЯ ТОГО, ЧТОБЫ ПОДЕЛИТЬСЯ ПРИЛОЖЕНИЕМ
        ll_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareSub = getResources().getString(R.string.shareSub); // тема письма

                String shareBody = "Бесплатно:    https://play.google.com/store/apps/details?id=com.dev_marinov.xo"; //  тело письма
                intent.putExtra(Intent.EXTRA_SUBJECT, shareSub);
                intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(intent, "Поделиться игрой"));
            }
        });

        select_theme();
        schet_game_1_1();
        schet_game_player_pc();

        select_game();

        sound_stop();

        return frag;
    }

    // метод загулшения всех звуков приложения и включения
    public void sound_stop()
    {
        String sound_check = loadSettingString("sound_check", "0");
        if (sound_check.equals("1"))
        {

            audioManager =(AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, true);
            audioManager.setStreamMute(AudioManager.STREAM_ALARM, true);
            audioManager.setStreamMute(AudioManager.STREAM_MUSIC, true);
            audioManager.setStreamMute(AudioManager.STREAM_RING, true);
            audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, true);
        }
        else
        {
            audioManager = (AudioManager)getActivity().getSystemService(Context.AUDIO_SERVICE);
            audioManager.setStreamMute(AudioManager.STREAM_NOTIFICATION, false);
            audioManager.setStreamMute(AudioManager.STREAM_ALARM, false);
            audioManager.setStreamMute(AudioManager.STREAM_MUSIC, false);
            audioManager.setStreamMute(AudioManager.STREAM_RING, false);
            audioManager.setStreamMute(AudioManager.STREAM_SYSTEM, false);

        }
    }

    public void est_sopernik_blink()
    {
        String alert_check = loadSettingString("alert_check", "0");
        if (alert_check.equals("0"))
        {
            ll_est_sopernik.setVisibility(View.VISIBLE);
            anim = AnimationUtils.loadAnimation(getActivity(),R.anim.blink);
            tv_est_sopernik.startAnimation(anim);

        }
        if (alert_check.equals("1"))
        {
            ll_est_sopernik.setVisibility(View.GONE);
        }


    }

    public void select_game() // активная анимация для кнопок выбора игры
    {
            animationDrawable_bt_game_online = (AnimationDrawable) bt_game_online.getBackground();
            animationDrawable_bt_game_online.setEnterFadeDuration(100);
            animationDrawable_bt_game_online.setExitFadeDuration(500);
            animationDrawable_bt_game_online.start();

            animationDrawable_bt_player_pc = (AnimationDrawable) bt_player_pc.getBackground();
            animationDrawable_bt_player_pc.setEnterFadeDuration(100);
            animationDrawable_bt_player_pc.setExitFadeDuration(500);
            animationDrawable_bt_player_pc.start();

            animationDrawable_bt_game_1_1 = (AnimationDrawable) bt_game_1_1.getBackground();
            animationDrawable_bt_game_1_1.setEnterFadeDuration(100);
            animationDrawable_bt_game_1_1.setExitFadeDuration(500);
            animationDrawable_bt_game_1_1.start();
    }




////////////////////////////////////////////////////////////////
    // ГЛАВНЫЕ МЕТОДЫ ИГРЫ GAME_ONLINE


    public void start_animation_game_online() {


            ll_panel_loading.setVisibility(View.GONE);
            //ll_main_block_left_game_online.setVisibility(View.VISIBLE); //  показать контейнеры игры online
            //ll_main_block_right_game_online.setVisibility(View.VISIBLE);

            delay_animation();

            if (check_winner_game_online() == 0) {
                tv_projector_screen.setText(getResources().getString(R.string.game_online));

                tv_projector_screen_2.setText("");


                // запихнуть задержку
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        game_online();
                    }
                }, 3000); // задержка выполнения кода на 3 сек

            }


        }





    public void ready_msg_server(String msg) {

       // Log.e("msg", "Fragmsg=" + msg);
        // {"start_game_online":"0","id_user1":4585829,"id_user2":4569384}

        try {
            JSONObject jsonObject_1 = new JSONObject(msg);
            String cmd = jsonObject_1.getString("cmd");

            if (cmd.equals("delete_free_player_appeared"))
            {
                id_user_free = "";
                Log.e("free","delete_free_player_appeared");
                ll_est_sopernik.setVisibility(View.GONE); // мигающее сообщение что есть соперник
            }
            if (cmd.equals("free_player_appeared"))
            {
                id_user_free = jsonObject_1.getString("id_user_free");
                Log.e("free","free_player_appeared");
                est_sopernik_blink(); // мигающее сообщение что есть соперник
                tv_startGame.setVisibility(View.GONE);
            }



          //  Log.e("String_cmd", "String_cmd =" + cmd);

            if (cmd.equals("sopernik_off")) {
              //  Toast.makeText(getContext(), "SOPERNIK_OFF = " + this_game, Toast.LENGTH_LONG).show();

                ll_panel_loading.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);
                tv_startGame.setText(getResources().getString(R.string.close_app));
               // this_game = ""; // чтобы ключить аинмацию градиента кнопок выбора типа игры
                //        Toast.makeText(frag.getContext(),"sopernik_off",Toast.LENGTH_LONG).show();
                //        Log.e("sopernik","off");


                // активная анимация для кнопок выбора игры
                bt_game_online.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                bt_player_pc.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                bt_game_1_1.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                select_game();


                close_tv_bt_all();
                set_click_disabled();
                img_first_step.setVisibility(View.GONE);
                tv_message_user.setText("");
            }
            if (cmd.equals("stop_game"))
            {
                Log.e("free","stop_game");
               // Toast.makeText(getContext(), "STOP_GAME = " + this_game, Toast.LENGTH_LONG).show();

             //   id_user_free = "";
                ll_panel_loading.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

                tv_startGame.startAnimation(anim);
                tv_startGame.setText(getResources().getString(R.string.sopernik_select_game));
                tv_startGame.setVisibility(View.VISIBLE);
              //  this_game = ""; // чтобы ключить аинмацию градиента кнопок выбора типа игры


                // активная анимация для кнопок выбора игры
                bt_game_online.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                bt_player_pc.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                bt_game_1_1.setBackground(getResources().getDrawable(R.drawable.grad_button_list));
                select_game();


                close_tv_bt_all();
                set_click_disabled();
                img_first_step.setVisibility(View.GONE);
                tv_message_user.setText("");
            }

            if (cmd.equals("start_game_online")) {  // Начало игры.
              //  Toast.makeText(getContext(), "START = " + this_game, Toast.LENGTH_LONG).show();

                ll_est_sopernik.setVisibility(View.GONE); // убрать сообщение о свободном сопернике
                tv_startGame.setVisibility(View.GONE);

                charGamer = jsonObject_1.getString("charGamer"); // юсеру 1 отправляется x, а 2 ноль
                // на данный момент кто последний подключился, тот первый ходит за Х

                id_user1 = jsonObject_1.getString("id_user1");
                id_user2 = jsonObject_1.getString("id_user2");
                id_game = jsonObject_1.getString("id_game");

                Log.e("id_user1", "============" + id_user1);
                Log.e("id_user2", "============" + id_user2);
                Log.e("id_game", "============" + id_game);

                if (charGamer.equals("X")) {
                    // запихнуть задержку
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tv_message_user.setText(getResources().getString(R.string.your_first_move));
                            img_first_step.setVisibility(View.VISIBLE);
                            update_image_for_theme_top_game_online_X(); // у кого первый ход за крестик, на верху появиться крестик
                            close_tv_bt();
                        }
                    }, 3000); // задержка выполнения кода на 3 сек

                    } else {

                    // запихнуть задержку
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tv_message_user.setText(getResources().getString(R.string.waiting_for_my_opponents_move));
                            img_first_step.setVisibility(View.VISIBLE);
                            update_image_for_theme_top_game_online_X(); //  у кого первый ход за нолик, на верху появиться нолик
                            close_tv_bt_all();
                        }
                    }, 3000); // задержка выполнения кода на 3 сек
                }
                    start_animation_game_online(); // анимация с методом game_online(); внутри с задержкой

                ll_panel_loading.setVisibility(View.GONE);
                ll_conteiner_bt.setVisibility(View.VISIBLE);

                Log.e("start_game_online", "" + charGamer);
            }

            if (cmd.equals("update")) // данные пришли с сервера чтобы обновить игрвовое поле
            {
                String value = jsonObject_1.getString("value"); // {"1":"X","2":"X","3":"0","4":"","5":"0","6":"0","7":"0","8":"X","9":"X"}}
                String kto_hodil = jsonObject_1.getString("kto_hodil"); // или X или 0 - кто ходил
                Log.e("String_kto_hodil ", "==========" + kto_hodil);

                try {
                    JSONObject jsonObject_2 = new JSONObject(value);

                    for (int i = 1; i <= 9; i++) {
                        String val = jsonObject_2.getString(String.valueOf(i)); // получаем значение игоровго поля X 0 или пусто

                        if (i == 1) {

                            // после того как игрок нажал на поле на своем телефоне, сработал метод game_online() и на сервер ушло это нажатие,
                            // далее здесь считывается это нажатие с помощью цикла, который пробегается по все полям и выводил это нажатие на телефоне соперника.
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_1.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_1, то R.drawable.krestik
                                    //tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            }
                            else { //Иначе пусто
                            tv_bt_1.setEnabled(true); // иначе разблокируем
                            }

                            tv_bt_1.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            tv_bt_1.setTextColor(getResources().getColor(android.R.color.transparent));
                           }
                        if (i == 2) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_2.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_2, то R.drawable.krestik
                                    //tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                    //tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_2.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_2.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_2.setTextColor(getResources().getColor(android.R.color.transparent));
                             }
                        if (i == 3) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_3.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_3, то R.drawable.krestik
                                  //  tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_3.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_3.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_3.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 4) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_4.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_4, то R.drawable.krestik
                                   // tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_4.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_4.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_4.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 5) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_5.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_5, то R.drawable.krestik
                                    //tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                    //tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_5.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_5.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_5.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 6) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_6.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_6, то R.drawable.krestik
                                   // tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_6.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_6.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_6.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 7) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_7.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_7, то R.drawable.krestik
                                    //tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_7.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_7.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_7.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 8) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_8.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_8, то R.drawable.krestik
                                   // tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_8.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_8.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            // установка прозразности при отображении, чтобы не было видно
                            tv_bt_8.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        if (i == 9) {
                            if (val.equals("X") || val.equals("0")) { // если пришло x или 0
                                tv_bt_9.setEnabled(false); // то поле блокируем
                                if (val.equals("X")) { // если юзер играющий за Х нажал на tv_bt_9, то R.drawable.krestik
                                   // tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik));
                                } else { // иначе R.drawable.nolik
                                   // tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik));
                                }
                            } else //Иначе пусто
                            {
                                tv_bt_9.setEnabled(true); // иначе разблокируем
                            }
                            tv_bt_9.setText(val); // установка знаечния x 0 или пусто. НЕ УДАЛЯТЬ
                            tv_bt_9.setTextColor(getResources().getColor(android.R.color.transparent));
                        }
                        Log.e("myval", " val = " + val);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (kto_hodil.equals(charGamer)) {
                    tv_message_user.setText(getResources().getString(R.string.waiting_for_my_opponents_move));
                    close_tv_bt_all();
                    if (charGamer.equals("X"))      // смена img_first_step
                    {
                        update_image_for_theme_top_game_online_0();

                        if (temp_theme.equals("0")) {song_krestik.start();}
                        if (temp_theme.equals("1")) {song_krestik.start();}
                        if (temp_theme.equals("2")) {song_theme_2_krest.start();}
                        if (temp_theme.equals("3")) {song_theme_3_krest.start();}
                        if (temp_theme.equals("4")) {song_theme_4_krest.start();}
                        if (temp_theme.equals("5")) {song_theme_5_krest.start();}
                        if (temp_theme.equals("6")) {song_theme_6_krest.start();}
                        if (temp_theme.equals("7")) {song_theme_7_krest.start();}
                        if (temp_theme.equals("8")) {song_theme_8_krest.start();}
                        if (temp_theme.equals("9")) {song_theme_9_krest.start();}
                        if (temp_theme.equals("10")) {song_theme_10_krest.start();}
                        if (temp_theme.equals("11")) {song_theme_11_krest.start();}
                        if (temp_theme.equals("12")) {song_theme_12_krest.start();}
                    }
                    else
                        {
                            update_image_for_theme_top_game_online_X();

                            if (temp_theme.equals("0")) {song_nolik.start();}
                            if (temp_theme.equals("1")) {song_nolik.start();}
                            if (temp_theme.equals("2")) {song_theme_2_nolik.start();}
                            if (temp_theme.equals("3")) {song_theme_3_nolik.start();}
                            if (temp_theme.equals("4")) {song_theme_4_nolik.start();}
                            if (temp_theme.equals("5")) {song_theme_5_nolik.start();}
                            if (temp_theme.equals("6")) {song_theme_6_nolik.start();}
                            if (temp_theme.equals("7")) {song_theme_7_nolik.start();}
                            if (temp_theme.equals("8")) {song_theme_8_nolik.start();}
                            if (temp_theme.equals("9")) {song_theme_9_nolik.start();}
                            if (temp_theme.equals("10")) {song_theme_10_nolik.start();}
                            if (temp_theme.equals("11")) {song_theme_11_nolik.start();}
                            if (temp_theme.equals("12")) {song_theme_12_nolik.start();}
                        }

                    update_image_for_theme_game_online();

                }
                else {
                    tv_message_user.setText(getResources().getString(R.string.your_move));
                    if (charGamer.equals("0"))       // смена img_first_step
                    {
                        update_image_for_theme_top_game_online_0();

                        if (temp_theme.equals("0")) {song_krestik.start();}
                        if (temp_theme.equals("1")) {song_krestik.start();}
                        if (temp_theme.equals("2")) {song_theme_2_krest.start();}
                        if (temp_theme.equals("3")) {song_theme_3_krest.start();}
                        if (temp_theme.equals("4")) {song_theme_4_krest.start();}
                        if (temp_theme.equals("5")) {song_theme_5_krest.start();}
                        if (temp_theme.equals("6")) {song_theme_6_krest.start();}
                        if (temp_theme.equals("7")) {song_theme_7_krest.start();}
                        if (temp_theme.equals("8")) {song_theme_8_krest.start();}
                        if (temp_theme.equals("9")) {song_theme_9_krest.start();}
                        if (temp_theme.equals("10")) {song_theme_10_krest.start();}
                        if (temp_theme.equals("11")) {song_theme_11_krest.start();}
                        if (temp_theme.equals("12")) {song_theme_12_krest.start();}
                    }
                    else
                        {
                            update_image_for_theme_top_game_online_X();

                            if (temp_theme.equals("0")) {song_nolik.start();}
                            if (temp_theme.equals("1")) {song_nolik.start();}
                            if (temp_theme.equals("2")) {song_theme_2_nolik.start();}
                            if (temp_theme.equals("3")) {song_theme_3_nolik.start();}
                            if (temp_theme.equals("4")) {song_theme_4_nolik.start();}
                            if (temp_theme.equals("5")) {song_theme_5_nolik.start();}
                            if (temp_theme.equals("6")) {song_theme_6_nolik.start();}
                            if (temp_theme.equals("7")) {song_theme_7_nolik.start();}
                            if (temp_theme.equals("8")) {song_theme_8_nolik.start();}
                            if (temp_theme.equals("9")) {song_theme_9_nolik.start();}
                            if (temp_theme.equals("10")) {song_theme_10_nolik.start();}
                            if (temp_theme.equals("11")) {song_theme_11_nolik.start();}
                            if (temp_theme.equals("12")) {song_theme_12_nolik.start();}
                        }

                    close_tv_bt();
                    update_image_for_theme_game_online();
                }
                check_gameover(); //Проверяем, есть победа или поражение.
            }
        } catch (Exception e) {
            Log.e("eee", "e=" + e);
        }
      //  Log.e("test", "msg==" + msg);
    }

        //Проверяем, есть победа или поражение. //Показывает на экране в случае поражения или победы
    public void check_gameover() {

            //текущий пользователь играет за крестики - он выйграл
        if (check_winner_game_online() == 1 && charGamer.equals("X")) {

            tv_message_user.setText("");

            delay_animation();
            tv_projector_screen.setText(getResources().getString(R.string.your_victory));
            tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
            img_first_step.setBackground(null);

            Gson json = new Gson();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("cmd", "start_game_online");
            String json_string = json.toJson(hashMap);
    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
            ((MainActivity) getActivity()).clws.send(json_string);
        }

        //текущий пользователь играет за крестики - он проиграл
        if (check_winner_game_online() == 1 && !charGamer.equals("X")) {

            tv_message_user.setText("");

            delay_animation();
            tv_projector_screen.setText(getResources().getString(R.string.opponent_won));
            tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
            img_first_step.setBackground(null);

            Gson json = new Gson();
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("cmd","start_game_online");
            String json_string = json.toJson(hashMap);
    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
            ((MainActivity) getActivity()).clws.send(json_string);

        }

        //текущий пользователь играет за нолики - он выйграл
        if (check_winner_game_online() == 2 && charGamer.equals("0")) {
            tv_message_user.setText("");

            delay_animation();

            tv_projector_screen.setText(getResources().getString(R.string.your_victory));
            tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
            img_first_step.setBackground(null);

            Gson json = new Gson();
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("cmd", "start_game_online");
            String json_string = json.toJson(hashMap);
    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
            ((MainActivity) getActivity()).clws.send(json_string);

        }

        //текущий пользователь играет за нолики - он проиграл
        if (check_winner_game_online() == 2 && !charGamer.equals("0")) {
            tv_message_user.setText("");

            delay_animation();

            tv_projector_screen.setText(getResources().getString(R.string.not_win));
            tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
            img_first_step.setBackground(null);

            Gson json = new Gson();
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("cmd","start_game_online");
            String json_string = json.toJson(hashMap);
    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
            ((MainActivity) getActivity()).clws.send(json_string);

        }

        if (check_winner_game_online() == 3)
        {
            Gson json = new Gson();
            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("cmd","start_game_online");
            String json_string = json.toJson(hashMap);
    // когда я нажал на кнопку играть online отправляется команда серверу start_game_online, что он готов играть по ес
            ((MainActivity) getActivity()).clws.send(json_string);
        }



    }


    public void xod(String pole)
    {
        Gson json = new Gson();
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("cmd","xod");
        hashMap.put("pole",pole);
        hashMap.put("charGamer",charGamer);
        hashMap.put("id_game",id_game);
        hashMap.put("id_user1",id_user1);
        hashMap.put("id_user2",id_user2);

        String json_string = json.toJson(hashMap);
        Log.e("xpd==","xod=="+json_string);
        ((MainActivity)getActivity()).clws.send(json_string);
    }


    public void game_online() {

        tv_bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("1");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_1, то R.drawable.krestik
                   // tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik));

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("2");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_2, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("3");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_3, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("4");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_4, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik


                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("5");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_5, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("6");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_6, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("7");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_7, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("8");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_8, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
        tv_bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // отправка json строку на сервер
                xod("9");
                // далее код для того, чтобы на поле отображалось рисунок Х или 0
                if (charGamer.equals("X")) { // если юзер играющий за Х нажал на tv_bt_9, то R.drawable.krestik

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                }
                else { // иначе R.drawable.nolik

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                }
            }
        });
    }



// метод победителя игры game_online

    public int check_winner_game_online() {

        // return 1 - моя победа, return 2 - поражение соперника, return -0 - игра продолжается
        // ПОБЕДЫ ПО ГОРИЗОНТАЛИ
        if (tv_bt_1.getText().equals("X") && tv_bt_2.getText().equals("X") && tv_bt_3.getText().equals("X"))
        {
                fr_ll_winner_line.setVisibility(View.VISIBLE);
                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
                return 1;
        }
        if (tv_bt_1.getText().equals("0") && tv_bt_2.getText().equals("0") && tv_bt_3.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
         return 2;
        }
        if (tv_bt_4.getText().equals("X") && tv_bt_5.getText().equals("X") && tv_bt_6.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
            return 1;
        }
        if (tv_bt_4.getText().equals("0") && tv_bt_5.getText().equals("0") && tv_bt_6.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
           return 2;
        }
        if (tv_bt_7.getText().equals("X") && tv_bt_8.getText().equals("X") && tv_bt_9.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
           return 1;
        }
        if (tv_bt_7.getText().equals("0") && tv_bt_8.getText().equals("0") && tv_bt_9.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
            return 2;
        }

        // ПОБЕДЫ ПО ВЕРТИКАЛИ
        if (tv_bt_1.getText().equals("X") && tv_bt_4.getText().equals("X") && tv_bt_7.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                return 1; // это значит что кто-то заполнил ХХХ и он был Х. return 1 для него
        }
        if (tv_bt_1.getText().equals("0") && tv_bt_4.getText().equals("0") && tv_bt_7.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                return 2;
        }

        if (tv_bt_2.getText().equals("X") && tv_bt_5.getText().equals("X") && tv_bt_8.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
            return 1;
        }
        if (tv_bt_2.getText().equals("0") && tv_bt_5.getText().equals("0") && tv_bt_8.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
                    return 2;
        }
        if (tv_bt_3.getText().equals("X") && tv_bt_6.getText().equals("X") && tv_bt_9.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
        return 1;
        }
        if (tv_bt_3.getText().equals("0") && tv_bt_6.getText().equals("0") && tv_bt_9.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
        return 2;
        }

        // ПОБЕДЫ ПО ДИАГАОНАЛИ
        if (tv_bt_1.getText().equals("X") && tv_bt_5.getText().equals("X") && tv_bt_9.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
        return 1;
        }
        if (tv_bt_1.getText().equals("0") && tv_bt_5.getText().equals("0") && tv_bt_9.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
         return 2;
        }
        if (tv_bt_7.getText().equals("X") && tv_bt_5.getText().equals("X") && tv_bt_3.getText().equals("X"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
        return 1;
        }
        if (tv_bt_7.getText().equals("0") && tv_bt_5.getText().equals("0") && tv_bt_3.getText().equals("0"))
        {
            fr_ll_winner_line.setVisibility(View.VISIBLE);
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
        return 2;
        }

        if (!tv_bt_1.getText().equals("") &&
                !tv_bt_2.getText().equals("") &&
                !tv_bt_3.getText().equals("") &&
                !tv_bt_4.getText().equals("") &&
                !tv_bt_5.getText().equals("") &&
                !tv_bt_6.getText().equals("") &&
                !tv_bt_7.getText().equals("") &&
                !tv_bt_8.getText().equals("") &&
                !tv_bt_9.getText().equals("") & winner_num_game_1_1 == 0) {
            delay_animation();
            tv_projector_screen.setText(getResources().getString(R.string.draw_game));

            tv_message_user.setText("");
            img_first_step.setBackground(null);

            return 3;
        }

        return 0; // ИГРА ПРОДОЛЖАЕТСЯ

    }


    public void update_image_for_theme_top_game_online_X()
    {
        if (temp_theme.equals("0") || temp_theme.equals("1")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet)); }
        if (temp_theme.equals("2")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
        if (temp_theme.equals("3")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
        if (temp_theme.equals("4")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
        if (temp_theme.equals("5")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
        if (temp_theme.equals("6")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
        if (temp_theme.equals("7")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
        if (temp_theme.equals("8")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
        if (temp_theme.equals("9")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
        if (temp_theme.equals("10")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
        if (temp_theme.equals("11")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
        if (temp_theme.equals("12")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
    }

    public void update_image_for_theme_top_game_online_0()
    {
        if (temp_theme.equals("0") || temp_theme.equals("1")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet)); }
        if (temp_theme.equals("2")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
        if (temp_theme.equals("3")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
        if (temp_theme.equals("4")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
        if (temp_theme.equals("5")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
        if (temp_theme.equals("6")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
        if (temp_theme.equals("7")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
        if (temp_theme.equals("8")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
        if (temp_theme.equals("9")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
        if (temp_theme.equals("10")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
        if (temp_theme.equals("11")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
        if (temp_theme.equals("12")) { img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
    }



    public void update_image_for_theme_game_online()
    {
        if (temp_theme.equals("0"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); }
        }

        if (temp_theme.equals("1"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); }
        }
        if (temp_theme.equals("2"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); }
        }
        if (temp_theme.equals("3"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); }
        }
        if (temp_theme.equals("4"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); }
        }
        if (temp_theme.equals("5"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); }
        }
        if (temp_theme.equals("6"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); }
        }
        if (temp_theme.equals("7"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); }
        }
        if (temp_theme.equals("8"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); }
        }
        if (temp_theme.equals("9"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); }
        }
        if (temp_theme.equals("10"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); }
        }
        if (temp_theme.equals("11"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); }
        }
        if (temp_theme.equals("12"))
        {
            if (tv_bt_1.getText().equals("X")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_2.getText().equals("X")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_3.getText().equals("X")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_4.getText().equals("X")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_5.getText().equals("X")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_6.getText().equals("X")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_7.getText().equals("X")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_8.getText().equals("X")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }
            if (tv_bt_9.getText().equals("X")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); }

            if (tv_bt_1.getText().equals("0")) { tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_2.getText().equals("0")) { tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_3.getText().equals("0")) { tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_4.getText().equals("0")) { tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_5.getText().equals("0")) { tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_6.getText().equals("0")) { tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_7.getText().equals("0")) { tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_8.getText().equals("0")) { tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
            if (tv_bt_9.getText().equals("0")) { tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); }
        }
    }







//////////////////////////////////////////////////
    // ГЛАВНЫЕ МЕТОДЫ ИГРЫ С КОМПЬЮТЕРОМ (PLAYER PC)


    // метод для вывода счета игры game_playar_pc() после перезагрузки приложения
    public void schet_game_player_pc() {
        String num_schet_game_player_1_0 = loadSettingString("player_pc_person_0", "0");
        tv_schet_right_1_0.setText(num_schet_game_player_1_0);

        String num_schet_right_game_player_1_x = loadSettingString("player_pc_person_x", "0");
        tv_schet_left_1_x.setText(num_schet_right_game_player_1_x);

        String num_schet_right_game_player_2_0 = loadSettingString("player_pc_android_0", "0");
        tv_schet_left_2_0.setText(num_schet_right_game_player_2_0);

        String num_schet_right_game_player_2_x = loadSettingString("player_pc_android_x", "0");
        tv_schet_right_2_x.setText(num_schet_right_game_player_2_x);
    }


    public void setting_1_0() {
        gamer_temp_player_pc = "1";
        XO_temp_player_pc = "0";

        tv_message_user.setText(getResources().getString(R.string.android_move));
        if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
        if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
        if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
        if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
        if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
        if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
        if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
        if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
        if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
        if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
        if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
        if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
        if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
    }

    public void setting_2_0() {
        gamer_temp_player_pc = "2";
        XO_temp_player_pc = "0";
    }

    public void setting_1_X() {
        gamer_temp_player_pc = "1";
        XO_temp_player_pc = "X";

        tv_message_user.setText(getResources().getString(R.string.android_move));

        if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
        if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
        if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
        if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
        if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
        if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
        if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
        if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
        if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
        if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
        if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
        if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
        if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
    }

    public void setting_2_X() {
        gamer_temp_player_pc = "2";
        XO_temp_player_pc = "X";
    }


    public void method_game_player_pc_1_x() {
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.your_victory));
        tv_projector_screen_2.setVisibility(View.VISIBLE);
        tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
        img_projector_XO.setVisibility(View.GONE);
//        img_projector_XO.setBackground(getResources().getDrawable(R.drawable.person));
        img_projector_XO_2.setVisibility(View.GONE);
//        img_projector_XO_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet_black));

        img_first_step.setVisibility(View.GONE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                game_player_pc();

            }
        }, 2500);


    }
    public void method_game_player_pc_1_0() {
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.your_victory));
        tv_projector_screen_2.setVisibility(View.VISIBLE);
        tv_projector_screen_2.setText(getResources().getString(R.string.lets_go));
        img_projector_XO.setVisibility(View.GONE);
//        img_projector_XO.setBackground(getResources().getDrawable(R.drawable.person));
        img_projector_XO_2.setVisibility(View.GONE);
//        img_projector_XO_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet_black));

        img_first_step.setVisibility(View.GONE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                game_player_pc();

            }
        }, 2500);

    }
    public void method_game_player_pc_2_0() {
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.android_winner));
        tv_projector_screen_2.setVisibility(View.GONE);
        tv_projector_screen_2.setText("");
//        img_projector_XO.setVisibility(View.VISIBLE);
//        img_projector_XO.setBackground(getResources().getDrawable(R.drawable.android));
//        img_projector_XO_2.setVisibility(View.VISIBLE);
//        img_projector_XO_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet_black));

        tv_message_user.setText("");
        img_first_step.setVisibility(View.GONE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                game_player_pc();

            }
        }, 2500);
    }
    public void method_game_player_pc_2_x() {
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.android_winner));
        tv_projector_screen_2.setVisibility(View.GONE);
        tv_projector_screen_2.setText("");
//        img_projector_XO.setVisibility(View.VISIBLE);
//        img_projector_XO.setBackground(getResources().getDrawable(R.drawable.android));
//        img_projector_XO_2.setVisibility(View.VISIBLE);
//        img_projector_XO_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet_black));

        tv_message_user.setText("");
        img_first_step.setVisibility(View.GONE);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                game_player_pc();

            }
        }, 2500);
    }


// метод game_player_pc
    public void game_player_pc() {

        // генерация случайного Х или 0. Это за кого первый игрок будет ходит
        X0_player_pc = "X0";
        int my_random_symbol_X0 = (int) (Math.random() * X0_player_pc.length());
        ch_player_pc = X0_player_pc.charAt(my_random_symbol_X0); // Х или 0

        player_pc = "12"; // 1 - player, 2 - android
        int my_random_number_gamer = (int) (Math.random() * player_pc.length());
        char_gamer_player_pc = player_pc.charAt(my_random_number_gamer); // 1 или 2

        gamer_temp_player_pc = String.valueOf(char_gamer_player_pc);
        XO_temp_player_pc = String.valueOf(ch_player_pc); // получение string из char

        if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я за Х
            tv_message_user.setText(getResources().getString(R.string.one_step_you)); // первым ходите вы за крестик

            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}


            // когда сработает рандом выбора комбинации игры (кто за кого ходит), то выделятся эти элементы
            tv_schet_left_1_x.setTypeface(null, Typeface.BOLD);
            tv_schet_left_2_0.setTypeface(null, Typeface.BOLD);
            tv_tire_1_x.setTypeface(null, Typeface.BOLD);
            tv_tire_2_0.setTypeface(null, Typeface.BOLD);
            img_select_krestik_1.setBackground(getResources().getDrawable(R.drawable.krestik_schet_select));
            img_select_nolik_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet_select));

            tv_schet_right_2_x.setTypeface(null, Typeface.NORMAL);
            tv_schet_right_1_0.setTypeface(null, Typeface.NORMAL);
            tv_tire_2_x.setTypeface(null, Typeface.NORMAL);
            tv_tire_1_0.setTypeface(null, Typeface.NORMAL);
            img_select_krestik_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet));
            img_select_nolik_1.setBackground(getResources().getDrawable(R.drawable.nolik_schet));

        } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) { // если выпало что андроид за 0
            easy_logic("0"); // рандомный ход РС
            tv_message_user.setText(getResources().getString(R.string.one_step_android)); // первым сходил андроид за нолик, теперь вы за крестик

            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}

            tv_schet_left_1_x.setTypeface(null, Typeface.BOLD);
            tv_schet_left_2_0.setTypeface(null, Typeface.BOLD);
            tv_tire_1_x.setTypeface(null, Typeface.BOLD);
            tv_tire_2_0.setTypeface(null, Typeface.BOLD);
            img_select_krestik_1.setBackground(getResources().getDrawable(R.drawable.krestik_schet_select));
            img_select_nolik_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet_select));

            tv_schet_right_2_x.setTypeface(null, Typeface.NORMAL);
            tv_schet_right_1_0.setTypeface(null, Typeface.NORMAL);
            tv_tire_2_x.setTypeface(null, Typeface.NORMAL);
            tv_tire_1_0.setTypeface(null, Typeface.NORMAL);
            img_select_krestik_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet));
            img_select_nolik_1.setBackground(getResources().getDrawable(R.drawable.nolik_schet));
        }

        if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) { // если выпало что я за 0
            tv_message_user.setText(getResources().getString(R.string.one_step_you)); // первым ходите вы за нолик

            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}

            tv_schet_right_2_x.setTypeface(null, Typeface.BOLD);
            tv_schet_right_1_0.setTypeface(null, Typeface.BOLD);
            tv_tire_2_x.setTypeface(null, Typeface.BOLD);
            tv_tire_1_0.setTypeface(null, Typeface.BOLD);
            img_select_krestik_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet_select));
            img_select_nolik_1.setBackground(getResources().getDrawable(R.drawable.nolik_schet_select));

            tv_schet_left_1_x.setTypeface(null, Typeface.NORMAL);
            tv_schet_left_2_0.setTypeface(null, Typeface.NORMAL);
            tv_tire_1_x.setTypeface(null, Typeface.NORMAL);
            tv_tire_2_0.setTypeface(null, Typeface.NORMAL);
            img_select_krestik_1.setBackground(getResources().getDrawable(R.drawable.krestik_schet));
            img_select_nolik_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet));

        } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) { // если выпало что андроид за Х
            easy_logic("X");  // рандомный ход РС
            tv_message_user.setText(getResources().getString(R.string.one_step_android)); // сходил android за крестик, теперь вы за нолик

            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}





            tv_schet_right_2_x.setTypeface(null, Typeface.BOLD);
            tv_schet_right_1_0.setTypeface(null, Typeface.BOLD);
            tv_tire_2_x.setTypeface(null, Typeface.BOLD);
            tv_tire_1_0.setTypeface(null, Typeface.BOLD);
            img_select_krestik_2.setBackground(getResources().getDrawable(R.drawable.krestik_schet_select));
            img_select_nolik_1.setBackground(getResources().getDrawable(R.drawable.nolik_schet_select));

            tv_schet_left_1_x.setTypeface(null, Typeface.NORMAL);
            tv_schet_left_2_0.setTypeface(null, Typeface.NORMAL);
            tv_tire_1_x.setTypeface(null, Typeface.NORMAL);
            tv_tire_2_0.setTypeface(null, Typeface.NORMAL);
            img_select_krestik_1.setBackground(getResources().getDrawable(R.drawable.krestik_schet));
            img_select_nolik_2.setBackground(getResources().getDrawable(R.drawable.nolik_schet));
        }

        tv_bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х

                    tv_bt_1.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_1.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_1.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_1.setText("X");

                    setting_1_X();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_1.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_1.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_1.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_1.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_2.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}


                    tv_bt_2.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_2.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_2.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");


                    setting_2_0();

                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_2.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_2.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_2.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_2.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });

        tv_bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_3.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_3.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_3.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_3.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();

                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_3.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_3.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_3.setTextColor(Color.TRANSPARENT);


                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_3.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_4.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_4.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_4.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_4.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_4.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_4.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_4.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_4.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_5.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_5.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_5.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_5.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_5.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_5.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_5.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_5.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_6.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_6.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_6.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_6.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_6.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_6.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }

                    close_tv_bt();
                    easy_logic("X");

                    setting_2_X();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_6.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_6.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_7.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_7.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_7.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_7.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_7.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_7.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_7.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_7.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_8.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_8.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();
                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_8.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_8.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();
                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_8.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_8.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_8.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_8.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
        tv_bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) { // если выпало что я хожу за х, то при нажатии на tv_bt_1 там появится Х
                    tv_bt_9.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_9.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0"); // тут андроид ход рандомно в своем методе easy_logic

                    setting_2_0();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                    tv_bt_9.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    tv_bt_9.setText("X");

                    setting_1_X();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }
                    close_tv_bt();

                    easy_logic("0");

                    setting_2_0();

                }
                if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                    tv_bt_9.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_9.setText("0");

                    setting_1_0();

                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {
                        return;
                    }

                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();

                } else if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                    tv_bt_9.setTextColor(Color.TRANSPARENT);

                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    tv_bt_9.setText("0");

                    setting_1_0();
                    winner_game_player_pc();
                    if (winner_num_player_pc == 1) {

                        return;
                    }
                    close_tv_bt();

                    easy_logic("X");

                    setting_2_X();
                }
                close_tv_bt();
                winner_game_player_pc();
            }
        });
    }


    // метод логики на легком уровне игры с player против PC (андроид)
    public void easy_logic(final String string_XO_temp) {

        set_click_disabled();

// задержка выполнения кода для имитации думания андройда при ходе
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                int random_index = 0;
                TextView[] textViews = new TextView[]{tv_bt_1, tv_bt_2, tv_bt_3, tv_bt_4, tv_bt_5, tv_bt_6, tv_bt_7, tv_bt_8, tv_bt_9};

                for (int i = 0; i < 100; i++) {
                    random_index = (int) (Math.random() * textViews.length); // рандомный поиск любого textview

                    if (textViews[random_index].getText().equals("")) { // если рандомный textview пустой, то туда запишется Х или 0 хода андроид
                        textViews[random_index].setTextColor(getResources().getColor(android.R.color.transparent));
                        textViews[random_index].setText(string_XO_temp);

                        if (string_XO_temp.equals("0")) {

                            if (temp_theme.equals("0")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                            if (temp_theme.equals("1")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                            if (temp_theme.equals("2")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                            if (temp_theme.equals("3")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                            if (temp_theme.equals("4")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                            if (temp_theme.equals("5")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                            if (temp_theme.equals("6")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                            if (temp_theme.equals("7")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                            if (temp_theme.equals("8")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                            if (temp_theme.equals("9")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                            if (temp_theme.equals("10")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                            if (temp_theme.equals("11")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                            if (temp_theme.equals("12")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                        } else {

                            if (temp_theme.equals("0")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                            if (temp_theme.equals("1")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                            if (temp_theme.equals("2")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                            if (temp_theme.equals("3")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                            if (temp_theme.equals("4")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                            if (temp_theme.equals("5")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                            if (temp_theme.equals("6")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                            if (temp_theme.equals("7")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                            if (temp_theme.equals("8")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                            if (temp_theme.equals("9")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                            if (temp_theme.equals("10")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                            if (temp_theme.equals("11")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                            if (temp_theme.equals("12")) {textViews[random_index].setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                        }

                        winner_game_player_pc();
                        close_tv_bt();
                        // еще одна задержка, так надо
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                tv_message_user.setText(getResources().getString(R.string.your_move));

                                if (XO_temp_player_pc.equals("0"))
                                {
                                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                                }
                                else
                                {
                                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                                }
                                set_click_enabled();
                                  }
                            }, 300); // задержка выполнения кода на 1 сек
                        break;
                    }
                }
            }
        }, 1500); // задержка выполнения кода на 1 сек

    }


    public void winner_game_player_pc() { // метод определящтй победителя по заполненным клеткам
        winner_num_player_pc = 0;

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_2.getText().equals("X") & tv_bt_3.getText().equals("X")) // по горизонтали X
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);
                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_2.getText().equals("0") & tv_bt_3.getText().equals("0"))  // по горизонтали 0
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);
                //tv_message_user.setText(getResources().getString(R.string.android_winner)); // сообщение победа android
                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);
              //  tv_message_user.setText("твоя победа! давай еще раз ");
                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_4.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_6.getText().equals("X")) // по горизонтали X
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_4.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_6.getText().equals("0"))  // по горизонтали 0
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_7.getText().equals("X") & tv_bt_8.getText().equals("X") & tv_bt_9.getText().equals("X")) // по горизонтали X
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_7.getText().equals("0") & tv_bt_8.getText().equals("0") & tv_bt_9.getText().equals("0")) // по горизонтали 0
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_4.getText().equals("X") & tv_bt_7.getText().equals("X")) // по вертикали Х
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_4.getText().equals("0") & tv_bt_7.getText().equals("0")) // по вертикали 0
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_2.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_8.getText().equals("X")) // по вертикали Х
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_2.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_8.getText().equals("0")) // по вертикали 0
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();
            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_3.getText().equals("X") & tv_bt_6.getText().equals("X") & tv_bt_9.getText().equals("X")) {

            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_3.getText().equals("0") & tv_bt_6.getText().equals("0") & tv_bt_9.getText().equals("0")) // ПО ВЕРТИКАЛИ СПРАВА
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_9.getText().equals("X")) // ПО ДИАГОНАЛИ СЛЕВА НАПРАВО
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_9.getText().equals("0")) // ПО ДИАГОНАЛИ СЛЕВА НАПРАВО
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            } else if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
                fr_ll_winner_line.setVisibility(View.VISIBLE);
              //  tv_message_user.setText("твоя победа! давай еще раз ");
                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_3.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_7.getText().equals("X")) // ПО ДИАГОНАЛИ СПРАВА НАЛЕВО
        {
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("X")) {
                count_player_pc_left_1_x++;
                saveSettingString("player_pc_person_x", count_player_pc_left_1_x);

                tv_schet_left_1_x.setText(String.valueOf(count_player_pc_left_1_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

               method_game_player_pc_1_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("X")) {
                count_player_pc_right_2_x++;
                saveSettingString("player_pc_android_x", count_player_pc_right_2_x);

                tv_schet_right_2_x.setText(String.valueOf(count_player_pc_right_2_x));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_x();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");
            song_cherta.setLooping(false); // воспроизведение 1 раз
            song_cherta.start();
            return; // ОСТАНОИТЬ КОД ЧТОБЫ НЕ ВЫИГРАВАЛ СОПЕРНИК ПОСЛЕ ТВОЕЙ ПОБЕДЫ
        }
        if (tv_bt_3.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_7.getText().equals("0")) // ПО ДИАГОНАЛИ СПРАВА НАЛЕВО
        {
            if (gamer_temp_player_pc.equals("2") && XO_temp_player_pc.equals("0")) {
                count_player_pc_left_2_0++;
                saveSettingString("player_pc_android_0", count_player_pc_left_2_0);

                tv_schet_left_2_0.setText(String.valueOf(count_player_pc_left_2_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_2_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            if (gamer_temp_player_pc.equals("1") && XO_temp_player_pc.equals("0")) {
                count_player_pc_right_1_0++;
                saveSettingString("player_pc_person_0", count_player_pc_right_1_0);

                tv_schet_right_1_0.setText(String.valueOf(count_player_pc_right_1_0));

                fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
                fr_ll_winner_line.setVisibility(View.VISIBLE);

                method_game_player_pc_1_0();
                close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
                delay_animation();

            }
            winner_num_player_pc = 1;
            tv_message_user.setText("");

        }
            if (!tv_bt_1.getText().equals("") &&
                !tv_bt_2.getText().equals("") &&
                !tv_bt_3.getText().equals("") &&
                !tv_bt_4.getText().equals("") &&
                !tv_bt_5.getText().equals("") &&
                !tv_bt_6.getText().equals("") &&
                !tv_bt_7.getText().equals("") &&
                !tv_bt_8.getText().equals("") &&
                !tv_bt_9.getText().equals("") & winner_num_player_pc == 0) {
                delay_animation();
                tv_projector_screen.setText(getResources().getString(R.string.draw_game));
                tv_message_user.setText("");

        }

    }

///////////////////////////////////////////////////////////////////
    // МЕТОДЫ ДЛЯ ИГРЫ GAME_1_1

    // метод для вывода счета игры game_1_1() после перезагрузки приложения
    public void schet_game_1_1() {

        String num_schet_left_game_1_1 = loadSettingString("game_1_1_x", "0");
        tv_schet_left_game_1_1.setText(num_schet_left_game_1_1);

        String num_schet_right_game_1_1 = loadSettingString("game_1_1_0", "0");
        tv_schet_right_game_1_1.setText(num_schet_right_game_1_1);
    }


    // метод для сокращения кода в методе winner_game_1_1()
    public void method_game_1_1_X() {
        count_game_1_1_left_x ++;
        saveSettingString("game_1_1_x", count_game_1_1_left_x); // ЗАПИСЬ В SHAREDPREF

        tv_schet_left_game_1_1.setText(String.valueOf(count_game_1_1_left_x));
        tv_message_user.setText("");
        img_first_step.setVisibility(View.GONE);
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.winner));
        img_projector_XO.setVisibility(View.VISIBLE);
        tv_projector_screen_2.setText("");

        if (temp_theme.equals("0")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.krestik_schet_black));}
        if (temp_theme.equals("1")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.krestik_schet_black));}
        if (temp_theme.equals("2")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
        if (temp_theme.equals("3")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
        if (temp_theme.equals("4")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
        if (temp_theme.equals("5")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
        if (temp_theme.equals("6")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
        if (temp_theme.equals("7")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
        if (temp_theme.equals("8")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
        if (temp_theme.equals("9")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
        if (temp_theme.equals("10")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
        if (temp_theme.equals("11")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
        if (temp_theme.equals("12")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi_black));}

        close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
        delay_animation();

        winner_num_game_1_1 = 1; // если х победил то запишу сюда 1
        song_cherta.start();

// после победы и после срабатывания шторки нужно чтобы появилось ссобщение с задержкой ПЕРВЫМ ХОДИТ для этого задерживаю код
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                game_1_1();
            }
        }, 3000); // задержка выполнения кода на 3 сек

    }

    // метод для сокращения кода в методе winner_game_1_1()
    public void method_game_1_1_0() {
        count_game_1_1_right_0 ++;
        saveSettingString("game_1_1_0", count_game_1_1_right_0); // ЗАПИСЬ В SHAREDPREF

        tv_schet_right_game_1_1.setText(String.valueOf(count_game_1_1_right_0));
        tv_message_user.setText("");
        img_first_step.setVisibility(View.GONE);
        fr_ll_winner_line.setVisibility(View.VISIBLE);
        tv_projector_screen.setVisibility(View.VISIBLE);
        tv_projector_screen.setText(getResources().getString(R.string.winner));
        img_projector_XO.setVisibility(View.VISIBLE);
        tv_projector_screen_2.setText("");

        if (temp_theme.equals("0")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.nolik_schet_black));}
        if (temp_theme.equals("1")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.nolik_schet_black));}
        if (temp_theme.equals("2")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
        if (temp_theme.equals("3")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
        if (temp_theme.equals("4")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
        if (temp_theme.equals("5")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
        if (temp_theme.equals("6")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
        if (temp_theme.equals("7")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
        if (temp_theme.equals("8")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
        if (temp_theme.equals("9")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
        if (temp_theme.equals("10")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
        if (temp_theme.equals("11")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
        if (temp_theme.equals("12")) {img_projector_XO.setBackground(getResources().getDrawable(R.drawable.theme_12_face_black));}

        close_tv_bt_all(); // блокировка всех клеток после победы любого игрока, чтобы счетчик не считал наатия в счетчик побед
        delay_animation();

        winner_num_game_1_1 = 1; // если ноль победил то запишу сюда 1
        song_cherta.start();

        // после победы и после срабатывания шторки нужно чтобы появилось ссобщение с задержкой ПЕРВЫМ ХОДИТ для этого задерживаю код
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                game_1_1();
            }
        }, 3000); // задержка выполнения кода на 3 сек
    }



    // МЕТОД ИГРЫ 1/1
    public void game_1_1() {

        // генерация случайного Х или 0 и вывод его в tv_message_user кто ходит первый
        X0_game_1_1 = "X0";
        int my_random_symbol = (int) (Math.random() * X0_game_1_1.length());
        ch_game_1_1 = X0_game_1_1.charAt(my_random_symbol);
        XO_temp_game_1_1 = String.valueOf(ch_game_1_1); // получение string из char

        if (XO_temp_game_1_1.equals("X")) {
            tv_message_user.setText(getResources().getString(R.string.first_step));
            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}

        } else {
            tv_message_user.setText(getResources().getString(R.string.first_step));
            img_first_step.setVisibility(View.VISIBLE);

            if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
            if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
            if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
            if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
            if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
            if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
            if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
            if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
            if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
            if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
            if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
            if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}

        }

        tv_bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_1.setTextColor(Color.TRANSPARENT);
                    tv_bt_1.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_1.setTextColor(Color.TRANSPARENT);
                    tv_bt_1.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_1.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }

            }
        });
        tv_bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_2.setTextColor(Color.TRANSPARENT);
                    tv_bt_2.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";
                    winner_game_1_1();

                    close_tv_bt(); // закрыть не пустые ячейки

                } else {
                    tv_bt_2.setTextColor(Color.TRANSPARENT);
                    tv_bt_2.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_2.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_3.setTextColor(Color.TRANSPARENT);
                    tv_bt_3.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_3.setTextColor(Color.TRANSPARENT);
                    tv_bt_3.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_3.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_4.setTextColor(Color.TRANSPARENT);
                    tv_bt_4.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_4.setTextColor(Color.TRANSPARENT);
                    tv_bt_4.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_4.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_5.setTextColor(Color.TRANSPARENT);
                    tv_bt_5.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_5.setTextColor(Color.TRANSPARENT);
                    tv_bt_5.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_5.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_6.setTextColor(Color.TRANSPARENT);
                    tv_bt_6.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_6.setTextColor(Color.TRANSPARENT);
                    tv_bt_6.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_6.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_7.setTextColor(Color.TRANSPARENT);
                    tv_bt_7.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_7.setTextColor(Color.TRANSPARENT);
                    tv_bt_7.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_7.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_8.setTextColor(Color.TRANSPARENT);
                    tv_bt_8.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}


                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_8.setTextColor(Color.TRANSPARENT);
                    tv_bt_8.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_8.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });
        tv_bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (XO_temp_game_1_1.equals("X")) {
                    tv_bt_9.setTextColor(Color.TRANSPARENT);
                    tv_bt_9.setText("X");
                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start(); }
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.krestik)); song_krestik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_flag)); song_theme_2_krest.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti)); song_theme_3_krest.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi)); song_theme_4_krest.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_krest)); song_theme_5_krest.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_mech)); song_theme_6_krest.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka)); song_theme_7_krest.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_amort)); song_theme_8_krest.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok)); song_theme_9_krest.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog)); song_theme_10_krest.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa)); song_theme_11_krest.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi)); song_theme_12_krest.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.nolik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_ball));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_shit));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_sir));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_pig));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_burger));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_face));}
                    XO_temp_game_1_1 = "0";

                    winner_game_1_1();
                    close_tv_bt(); // закрыть не пустые ячейки
                } else {
                    tv_bt_9.setTextColor(Color.TRANSPARENT);
                    tv_bt_9.setText("0");
                    if (temp_theme.equals("0")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("1")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.nolik)); song_nolik.start();}
                    if (temp_theme.equals("2")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_2_ball)); song_theme_2_nolik.start();}
                    if (temp_theme.equals("3")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_3_motor_itog)); song_theme_3_nolik.start();}
                    if (temp_theme.equals("4")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_4_roll_2)); song_theme_4_nolik.start();}
                    if (temp_theme.equals("5")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_5_inyan)); song_theme_5_nolik.start();}
                    if (temp_theme.equals("6")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_6_shit)); song_theme_6_nolik.start();}
                    if (temp_theme.equals("7")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_7_sir)); song_theme_7_nolik.start();}
                    if (temp_theme.equals("8")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_8_koleso)); song_theme_8_nolik.start();}
                    if (temp_theme.equals("9")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_9_pig)); song_theme_9_nolik.start();}
                    if (temp_theme.equals("10")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_10_burger)); song_theme_10_nolik.start();}
                    if (temp_theme.equals("11")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_11_planeta)); song_theme_11_nolik.start();}
                    if (temp_theme.equals("12")) {tv_bt_9.setBackground(getResources().getDrawable(R.drawable.theme_12_face)); song_theme_12_nolik.start();}

                    winner_game_1_1();
                    if (winner_num_game_1_1 == 1) {
                        return;
                    }
                    close_tv_bt(); // закрыть не пустые ячейки

                    tv_message_user.setText(getResources().getString(R.string.step));
                    if (temp_theme.equals("0")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("1")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.krestik_schet));}
                    if (temp_theme.equals("2")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_2_flag));}
                    if (temp_theme.equals("3")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_3_lopasti));}
                    if (temp_theme.equals("4")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_4_sushi));}
                    if (temp_theme.equals("5")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_5_krest));}
                    if (temp_theme.equals("6")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_6_mech));}
                    if (temp_theme.equals("7")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_7_rezka));}
                    if (temp_theme.equals("8")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_8_amort));}
                    if (temp_theme.equals("9")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_9_molotok));}
                    if (temp_theme.equals("10")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_10_hot_dog));}
                    if (temp_theme.equals("11")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_11_raketa));}
                    if (temp_theme.equals("12")) {img_first_step.setBackground(getResources().getDrawable(R.drawable.theme_12_nojnitsi));}
                    XO_temp_game_1_1 = "X";

                    winner_game_1_1();
                close_tv_bt(); // проверка если tv_bt не пустое, то поле блокируется, иначе не блокируется
                }
            }
        });

        winner_num_game_1_1 = 0;

    }



// метод определения победитя игры game_1_1
    public void winner_game_1_1() {

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_2.getText().equals("X") & tv_bt_3.getText().equals("X")) // по горизонтали X
        {

            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_2.getText().equals("0") & tv_bt_3.getText().equals("0"))  // по горизонтали 0
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_1));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_4.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_6.getText().equals("X")) // по горизонтали X
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_4.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_6.getText().equals("0"))  // по горизонтали 0
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_2));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_7.getText().equals("X") & tv_bt_8.getText().equals("X") & tv_bt_9.getText().equals("X")) // по горизонтали X
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_7.getText().equals("0") & tv_bt_8.getText().equals("0") & tv_bt_9.getText().equals("0")) // по горизонтали 0
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_goriz_3));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_4.getText().equals("X") & tv_bt_7.getText().equals("X")) // по вертикали Х
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_4.getText().equals("0") & tv_bt_7.getText().equals("0")) // по вертикали 0
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_1));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_2.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_8.getText().equals("X")) // по вертикали Х
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_2.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_8.getText().equals("0")) // по вертикали 0
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_2));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_3.getText().equals("X") & tv_bt_6.getText().equals("X") & tv_bt_9.getText().equals("X"))
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_3.getText().equals("0") & tv_bt_6.getText().equals("0") & tv_bt_9.getText().equals("0")) // ПО ВЕРТИКАЛИ СПРАВА
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_vert_3));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_1.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_9.getText().equals("X")) // ПО ДИАГОНАЛИ СЛЕВА НАПРАВО
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
        }

        // ДЛЯ ИГРОКА ЗА 0
        if (tv_bt_1.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_9.getText().equals("0")) // ПО ДИАГОНАЛИ СЛЕВА НАПРАВО
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_1));
        }

        // ДЛЯ ИГРОКА ЗА Х
        if (tv_bt_3.getText().equals("X") & tv_bt_5.getText().equals("X") & tv_bt_7.getText().equals("X")) // ПО ДИАГОНАЛИ СПРАВА НАЛЕВО
        {
            method_game_1_1_X();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
        }
        if (tv_bt_3.getText().equals("0") & tv_bt_5.getText().equals("0") & tv_bt_7.getText().equals("0")) // ПО ДИАГОНАЛИ СПРАВА НАЛЕВО
        {
            method_game_1_1_0();
            fr_ll_winner_line.setBackground(getResources().getDrawable(R.drawable.line_diagonal_2));
        }

        if (!tv_bt_1.getText().equals("") &&
                !tv_bt_2.getText().equals("") &&
                !tv_bt_3.getText().equals("") &&
                !tv_bt_4.getText().equals("") &&
                !tv_bt_5.getText().equals("") &&
                !tv_bt_6.getText().equals("") &&
                !tv_bt_7.getText().equals("") &&
                !tv_bt_8.getText().equals("") &&
                !tv_bt_9.getText().equals("") & winner_num_game_1_1 == 0) {
            delay_animation();
            tv_projector_screen.setText(getResources().getString(R.string.draw_game));
            img_projector_XO.setBackground(null);

        }

    }








}
