# spek-android-rx-extras

[![](https://jitpack.io/v/cc.femto/spek-rx-android-extras.svg)](https://jitpack.io/#cc.femto/spek-rx-android-extras)

[Spek](https://www.spekframework.org/) extension that injects and restores
[RxJava](https://github.com/ReactiveX/RxJava) schedulers before and after each test.

This defaults to `Schedulers.trampoline()`, but can be changed as needed.
A common use-case would be a custom `TestScheduler` in order to advance time.

## Binaries
```gradle
dependencies {
    testImplementation "cc.femto:spek-rx-android-extras:1.0.0"
}
```

Requires the JitPack repository:
```gradle
repositories {
    maven { url "https://jitpack.io" }
}
```
