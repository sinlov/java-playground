
playgroundGradleName ?= playground

playgroundTasks:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):tasks

playgroundTasksAll:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):tasks --all

playgroundClean:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):clean

playgroundDependencies:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):dependencies

playgroundDependDefault:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):dependencies --configuration default

playgroundDependCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):dependencies --configuration compileClasspath

playgroundDependentComponents:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):dependentComponents

playgroundTest:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):test

playgroundTestInfo: playgroundClean
	@${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):test --info

playgroundJacocoTestReport:
	${ENV_GRADLE_WRAPPER_EXEC} :$(playgroundGradleName):jacocoTestReport

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