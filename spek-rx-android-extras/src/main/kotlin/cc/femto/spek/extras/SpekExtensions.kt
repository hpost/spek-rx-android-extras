package cc.femto.spek.extras

import io.reactivex.Scheduler
import org.spekframework.spek2.dsl.GroupBody
import org.spekframework.spek2.dsl.Skip

inline fun GroupBody.rxGroup(
    description: String,
    skip: Skip = Skip.No,
    scheduler: Scheduler? = null,
    crossinline body: GroupBody.() -> Unit
) {
    group(description, skip) {
        beforeEachTest {
            RxSchedulerHooks.reset() // failed tests fail to reset afterwards
            if (scheduler != null) {
                RxSchedulerHooks.registerHooksForTesting(scheduler)
            } else {
                RxSchedulerHooks.registerHooksForTesting()
            }
        }
        body()
        afterEachTest {
            RxSchedulerHooks.reset()
        }
    }
}
