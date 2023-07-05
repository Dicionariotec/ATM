node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    withSonarQubeEnv() {
      sh "./gradlew sonar"
    }
  }

  stage('JUnit tests and build') {
    withGradle {
      sh './gradlew build --scan'
    }
  }

  stage('Assembles jar') {
    withGradle {
      sh './gradlew jar'
    }
  }

  stage('Upload') {
    nexusPublisher nexusInstanceId: 'ATMRespository', nexusRepositoryId: 'maven-releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '/Users/italoricardogeske/.jenkins/workspace/ATMSonarqube/app/build/libs/app.jar']], mavenCoordinate: [artifactId: 'atm', groupId: 'com.dicionariotec.atm', packaging: 'jar', version: '1.0.0']]]
  }
}