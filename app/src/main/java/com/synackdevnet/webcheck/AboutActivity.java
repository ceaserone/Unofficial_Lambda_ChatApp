package com.synackdevnet.webcheck;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView body = findViewById(R.id.aboutBody);

        // Title kept inside the same TextView, centered via XML
        String html = ""
            + "🔹 <b>About Lambda Chat App</b> 🔹<br/><br/>"
            + "💯 LambdaChat is a sleek, user-friendly wrapper designed<br/>"
            + "to provide seamless access to the powerful Lambda.chat.<br/>"
            + "We've built a focused experience that lets you dive straight<br/>"
            + "into Lambda's state-of-the-art open source AI models.<br/><br/>"
            + "👍 Built with passion by a few lamer's over at SynAckNet!<br/>"
            + "and of course the new ~$DEVNet. We're dedicated to<br/>"
            + "creating tools that empower users and push the oldschool<br/>"
            + "Hacker feel to everything IT. 🏴‍☠️<br/><br/>"
            + "⚠️ Get Involved!<br/>"
            + "👉 View the GitHub: <a href='https://github.com/ceaserone/Unofficial_Lambda_ChatApp'>GitHub repo</a><br/>"
            + "👉 Visit <a href='https://synacknetwork.com'>SynAckNetwork.com</a><br/>"
            + "👉 Email Us: <a href='mailto:devnet@synacknetwork.com'>devnet@synacknetwork.com</a><br/><br/>"
            + "🏴‍☠️ Be sure to check our other apps out!<br/>"
            + "We have a suite of tools for developers, security enthusiasts,<br/>"
            + "power users, and hackers. 💯<br/><br/>"
            + "🌀 Get Access 2 Restricted Content 🌀<br/>"
            + "💥 Our private IP Database is for vetted members.<br/>"
            + "💥 Inquire within for access protocols &amp; API Access.";

        body.setText(Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY));
        body.setMovementMethod(LinkMovementMethod.getInstance());

        TextView close = findViewById(R.id.btnClose);
        if (close != null) close.setOnClickListener(v -> finish());
    }
}