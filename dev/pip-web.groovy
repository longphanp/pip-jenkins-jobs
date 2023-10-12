pipelineJob('pip-web') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        name('origin')
                        url('git@github.com:longphanp/pip-jenkins.git')
                        credentials('jenkins-git')
                    }
                    branches('dev')
                }
            }
            scriptPath('jenkins/Jenkinsfile')
        }
    }

    triggers {
        scm('* * * * *')
    }
}
