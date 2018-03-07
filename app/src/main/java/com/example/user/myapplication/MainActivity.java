package com.example.user.myapplication;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        final Student aStudent=new Student("Junaet Hossain",25);
        aStudent.setImageUrl("https://www.facebook.com/photo.php?fbid=1547762218678153&set=a.101744279946628.1800.100003331683564&type=3&theater");
        binding.setAStudent(aStudent);

        binding.etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
               aStudent.setName(editable.toString());
            }
        });
    }


    public class Student{
        public final ObservableField<String> name=new ObservableField<>();

       // String name;
       int age;
       String imageUrl;

        public Student(String name, int age) {
            this.name.set(name);
            this.age = age;
        }

        public void setName(String name) {
            this.name.set(name);
        }

//        public String getName() {
//            return name;
//        }

        public int getAge() {
            return age;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }
    }

    @BindingAdapter("imageUrl")
    public void loadImage(ImageView iv, String url){
        Glide.with(iv.getContext())
                .load(url)
                .into(iv);
    }
}
