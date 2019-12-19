// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MessageActivity_ViewBinding implements Unbinder {
  private MessageActivity target;

  @UiThread
  public MessageActivity_ViewBinding(MessageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MessageActivity_ViewBinding(MessageActivity target, View source) {
    this.target = target;

    target.btn = Utils.findRequiredViewAsType(source, R.id.btn, "field 'btn'", Button.class);
    target.tv = Utils.findRequiredViewAsType(source, R.id.tv, "field 'tv'", TextView.class);
    target.rating = Utils.findRequiredViewAsType(source, R.id.rating, "field 'rating'", RatingBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MessageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.btn = null;
    target.tv = null;
    target.rating = null;
  }
}
