// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNoticeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ListView lvNotice;

  @NonNull
  public final CardNoticeBinding noticePost;

  private FragmentNoticeBinding(@NonNull ConstraintLayout rootView, @NonNull ListView lvNotice,
      @NonNull CardNoticeBinding noticePost) {
    this.rootView = rootView;
    this.lvNotice = lvNotice;
    this.noticePost = noticePost;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNoticeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNoticeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notice, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNoticeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.lvNotice;
      ListView lvNotice = ViewBindings.findChildViewById(rootView, id);
      if (lvNotice == null) {
        break missingId;
      }

      id = R.id.noticePost;
      View noticePost = ViewBindings.findChildViewById(rootView, id);
      if (noticePost == null) {
        break missingId;
      }
      CardNoticeBinding binding_noticePost = CardNoticeBinding.bind(noticePost);

      return new FragmentNoticeBinding((ConstraintLayout) rootView, lvNotice, binding_noticePost);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
