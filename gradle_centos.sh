yum install -y wget unzip
cd /tmp
wget https://services.gradle.org/distributions/gradle-6.3-bin.zip
unzip gradle-*.zip
mkdir /opt/gradle -p
cp -pr gradle-*/* /opt/gradle

echo "export PATH=/opt/gradle/bin:${PATH}" | tee /etc/profile.d/gradle.sh
chmod +x /etc/profile.d/gradle.sh
