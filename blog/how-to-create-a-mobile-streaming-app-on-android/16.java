<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:tools="http://schemas.android.com/tools"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 android:background="@color/black"
 android:id="@+id/streamPlayer"
 tools:context=".screens.StreamPlayerFragment">
 <VideoView
 android:id="@+id/videoView"
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:layout_gravity="center"/>
 ...
</FrameLayout>