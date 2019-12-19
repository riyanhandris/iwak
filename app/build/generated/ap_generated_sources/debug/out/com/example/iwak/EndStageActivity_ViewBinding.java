// Generated code from Butter Knife. Do not modify!
package com.example.iwak;

import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class EndStageActivity_ViewBinding implements Unbinder {
  private EndStageActivity target;

  @UiThread
  public EndStageActivity_ViewBinding(EndStageActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public EndStageActivity_ViewBinding(EndStageActivity target, View source) {
    this.target = target;

    target.stage = Utils.findRequiredViewAsType(source, R.id.stage, "field 'stage'", TextView.class);
    target.rating = Utils.findRequiredViewAsType(source, R.id.rating, "field 'rating'", RatingBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    EndStageActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.stage = null;
    target.rating = null;
  }
}
