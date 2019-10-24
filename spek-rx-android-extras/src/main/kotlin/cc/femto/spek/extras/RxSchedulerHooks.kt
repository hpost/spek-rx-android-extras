package cc.femto.spek.extras

import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

object RxSchedulerHooks {

    fun registerHooksForTesting(scheduler: Scheduler = Schedulers.trampoline()) {
        RxJavaPlugins.setInitIoSchedulerHandler { scheduler }
        RxJavaPlugins.setIoSchedulerHandler { scheduler }

        RxJavaPlugins.setInitComputationSchedulerHandler { scheduler }
        RxJavaPlugins.setComputationSchedulerHandler { scheduler }

        RxJavaPlugins.setInitNewThreadSchedulerHandler { scheduler }
        RxJavaPlugins.setNewThreadSchedulerHandler { scheduler }

        RxAndroidPlugins.setInitMainThreadSchedulerHandler { scheduler }
        RxAndroidPlugins.setMainThreadSchedulerHandler { scheduler }
    }

    fun reset() {
        RxJavaPlugins.reset()
        RxAndroidPlugins.reset()
    }
}