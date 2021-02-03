
playgroundGradleName ?= playground

playgroundTasks:
	./gradlew :$(playgroundGradleName):tasks

playgroundTasksAll:
	./gradlew :$(playgroundGradleName):tasks --all

playgroundDependencies:
	./gradlew :$(playgroundGradleName):dependencies

playgroundDependDefault:
	./gradlew :$(playgroundGradleName):dependencies --configuration default

playgroundDependCompileClasspath:
	./gradlew :$(playgroundGradleName):dependencies --configuration compileClasspath

playgroundDependentComponents:
	./gradlew :$(playgroundGradleName):dependentComponents

playgroundTest:
	./gradlew :$(playgroundGradleName):test

help-playground-gradle:
	@echo "=> $(playgroundGradleName)/z-gradle.mk : gradle $(playgroundGradleName) task"
	@echo "make playgroundTasks                  -> show task of $(playgroundGradleName)"
	@echo "make playgroundTasksAll               -> show all task of $(playgroundGradleName)"
	@echo "make playgroundDependencies           -> $(playgroundGradleName) full dependencies"
	@echo "make playgroundDependDefault          -> $(playgroundGradleName) dependencies of default"
	@echo "make playgroundDependCompileClasspath -> $(playgroundGradleName) dependencies of compileClasspath"
	@echo "make playgroundDependentComponents    -> $(playgroundGradleName) dependentComponents"
	@echo "make playgroundTest                   -> $(playgroundGradleName) test case"
	@echo ""