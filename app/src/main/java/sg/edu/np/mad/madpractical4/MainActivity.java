package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent receiver1 = getIntent();
        String valuu = receiver1.getStringExtra("key");
        Intent receiver2 = getIntent();
        String valu2 = receiver2.getStringExtra("key1");
        sg.edu.np.mad.madpractical4.User user = new sg.edu.np.mad.madpractical4.User("" + valuu,""+valu2, 1, false);

        TextView tvName = findViewById(R.id.textView2);
        TextView tvDescription = findViewById(R.id.textView5);
        Button btnFollow = findViewById(R.id.button3);

        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(btnFollow.getText().toString() == "Follow")
                {
                    btnFollow.setText("Unfollow");
                    Toast.makeText(getApplicationContext(),"Followed",Toast.LENGTH_SHORT).show();

                }
                else{
                    btnFollow.setText("Follow");
                    Toast.makeText(getApplicationContext(),"Unfollowed",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}