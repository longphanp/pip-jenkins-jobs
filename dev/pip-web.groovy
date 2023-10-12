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

    configure {
        it / triggers << 'org.jenkinsci.plugins.gwt.GenericTrigger' {
          spec()
          token("pip_jenkins")
          causeString("Generic Cause")
        }
    }

    triggers {
        scm('* * * * *')
    }
}
