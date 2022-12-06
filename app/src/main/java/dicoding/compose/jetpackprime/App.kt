package dicoding.compose.jetpackprime

import android.app.Application
import com.facebook.flipper.android.AndroidFlipperClient
import com.facebook.flipper.android.utils.FlipperUtils
import com.facebook.flipper.plugins.inspector.DescriptorMapping
import com.facebook.flipper.plugins.inspector.InspectorFlipperPlugin
import com.facebook.flipper.plugins.network.NetworkFlipperPlugin
import com.facebook.soloader.SoLoader
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App:Application(){
    @Inject
    lateinit var networkFlipperPlugin: NetworkFlipperPlugin

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            //#issue flipper ketika menjalankan instrument testing agar di komen
            SoLoader.init(this, false)

            if(FlipperUtils.shouldEnableFlipper(this)){
                val client = AndroidFlipperClient.getInstance(this)
                client.addPlugin(InspectorFlipperPlugin(this, DescriptorMapping.withDefaults()))
                client.addPlugin(networkFlipperPlugin)
                client.start()
            }

        }
    }
}