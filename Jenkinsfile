node
    {
        try {
            stage("build.clone")
            {
                checkout scm
            }
            stage("build.clean")
            {
                sh "./gradlew clean"
            }
            stage("build.package")
            {
                sh "./gradlew assembleDebug"
            }
        } catch (error) {
            throw error
        }
    }
