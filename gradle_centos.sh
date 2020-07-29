yum install -y wget unzip 
cd /tmp
wget https://services.gradle.org/distributions/gradle-6.3-bin.zip
unzip gradle-*.zip
mkdir /opt/gradle -p
cp -pr gradle-*/* /opt/gradle

printf "export PATH=/opt/gradle/bin:${PATH}\nexport JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.262.b10-0.el8_2.x86_64/" | tee /etc/profile.d/gradle.sh
chmod +x /etc/profile.d/gradle.sh
