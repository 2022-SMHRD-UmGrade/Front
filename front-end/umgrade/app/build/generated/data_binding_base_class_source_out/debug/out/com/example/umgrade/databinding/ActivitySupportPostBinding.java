// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySupportPostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final BottomNavigationView bottomNavigationView;

  @NonNull
  public final Button btnPostComment;

  @NonNull
  public final Button btnPostDelete;

  @NonNull
  public final Button btnPostModify;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final Guideline postBottom;

  @NonNull
  public final ScrollView scrollView4;

  @NonNull
  public final TextView tvPostCnt;

  @NonNull
  public final TextView tvPostContent;

  @NonNull
  public final TextView tvPostId;

  @NonNull
  public final TextView tvPostNick;

  @NonNull
  public final TextView tvPostPl1;

  @NonNull
  public final TextView tvPostPl2;

  @NonNull
  public final TextView tvPostTime;

  private ActivitySupportPostBinding(@NonNull ConstraintLayout rootView,
      @NonNull BottomNavigationView bottomNavigationView, @NonNull Button btnPostComment,
      @NonNull Button btnPostDelete, @NonNull Button btnPostModify,
      @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout3,
      @NonNull Guideline postBottom, @NonNull ScrollView scrollView4, @NonNull TextView tvPostCnt,
      @NonNull TextView tvPostContent, @NonNull TextView tvPostId, @NonNull TextView tvPostNick,
      @NonNull TextView tvPostPl1, @NonNull TextView tvPostPl2, @NonNull TextView tvPostTime) {
    this.rootView = rootView;
    this.bottomNavigationView = bottomNavigationView;
    this.btnPostComment = btnPostComment;
    this.btnPostDelete = btnPostDelete;
    this.btnPostModify = btnPostModify;
    this.constraintLayout = constraintLayout;
    this.constraintLayout3 = constraintLayout3;
    this.postBottom = postBottom;
    this.scrollView4 = scrollView4;
    this.tvPostCnt = tvPostCnt;
    this.tvPostContent = tvPostContent;
    this.tvPostId = tvPostId;
    this.tvPostNick = tvPostNick;
    this.tvPostPl1 = tvPostPl1;
    this.tvPostPl2 = tvPostPl2;
    this.tvPostTime = tvPostTime;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySupportPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySupportPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_support_post, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySupportPostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.bottomNavigationView;
      BottomNavigationView bottomNavigationView = ViewBindings.findChildViewById(rootView, id);
      if (bottomNavigationView == null) {
        break missingId;
      }

      id = R.id.btnPostComment;
      Button btnPostComment = ViewBindings.findChildViewById(rootView, id);
      if (btnPostComment == null) {
        break missingId;
      }

      id = R.id.btnPostDelete;
      Button btnPostDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnPostDelete == null) {
        break missingId;
      }

      id = R.id.btnPostModify;
      Button btnPostModify = ViewBindings.findChildViewById(rootView, id);
      if (btnPostModify == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.constraintLayout3;
      ConstraintLayout constraintLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout3 == null) {
        break missingId;
      }

      id = R.id.postBottom;
      Guideline postBottom = ViewBindings.findChildViewById(rootView, id);
      if (postBottom == null) {
        break missingId;
      }

      id = R.id.scrollView4;
      ScrollView scrollView4 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView4 == null) {
        break missingId;
      }

      id = R.id.tvPostCnt;
      TextView tvPostCnt = ViewBindings.findChildViewById(rootView, id);
      if (tvPostCnt == null) {
        break missingId;
      }

      id = R.id.tvPostContent;
      TextView tvPostContent = ViewBindings.findChildViewById(rootView, id);
      if (tvPostContent == null) {
        break missingId;
      }

      id = R.id.tvPostId;
      TextView tvPostId = ViewBindings.findChildViewById(rootView, id);
      if (tvPostId == null) {
        break missingId;
      }

      id = R.id.tvPostNick;
      TextView tvPostNick = ViewBindings.findChildViewById(rootView, id);
      if (tvPostNick == null) {
        break missingId;
      }

      id = R.id.tvPostPl1;
      TextView tvPostPl1 = ViewBindings.findChildViewById(rootView, id);
      if (tvPostPl1 == null) {
        break missingId;
      }

      id = R.id.tvPostPl2;
      TextView tvPostPl2 = ViewBindings.findChildViewById(rootView, id);
      if (tvPostPl2 == null) {
        break missingId;
      }

      id = R.id.tvPostTime;
      TextView tvPostTime = ViewBindings.findChildViewById(rootView, id);
      if (tvPostTime == null) {
        break missingId;
      }

      return new ActivitySupportPostBinding((ConstraintLayout) rootView, bottomNavigationView,
          btnPostComment, btnPostDelete, btnPostModify, constraintLayout, constraintLayout3,
          postBottom, scrollView4, tvPostCnt, tvPostContent, tvPostId, tvPostNick, tvPostPl1,
          tvPostPl2, tvPostTime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
