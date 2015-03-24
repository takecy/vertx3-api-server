# -*- mode: ruby -*-
# vi: set ft=ruby :

VAGRANTFILE_API_VERSION = "2"

Vagrant.configure(VAGRANTFILE_API_VERSION) do |config|

  # datastore
  config.vm.define "db" do |db|
    db.vm.box = "chef/centos-6.5"
    db.vm.provider "virtualbox" do |vb|
      vb.gui = true
      vb.customize ["modifyvm", :id, "--memory","1024"]
      vb.customize ["modifyvm", :id, "--cpus","1"]
      vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
    end
    db.vm.network "private_network", ip: "192.168.33.20"
    db.vm.network "forwarded_port", guest: 27017, host: 27017
    db.vm.network "forwarded_port", guest: 9200, host: 9200

    db.vm.provision "shell", inline: <<-SHELL
      sudo yum update
      sudo yum install -y mysql-server
      sudo rpm -ivh http://dl.fedoraproject.org/pub/epel/6/x86_64/epel-release-6-8.noarch.rpm
      sudo yum install -y redis
    SHELL
  end

  # api
  config.vm.define "api" do |api|
    api.vm.box = "chef/centos-6.5"
    api.vm.provider "virtualbox" do |vb|
      vb.gui = true
      vb.customize ["modifyvm", :id, "--memory","1024"]
      vb.customize ["modifyvm", :id, "--cpus","1"]
      vb.customize ["modifyvm", :id, "--natdnshostresolver1", "on"]
    end
    api.vm.network "private_network", ip: "192.168.33.21"
    api.vm.network "forwarded_port", guest: 80, host: 8080

    api.vm.provision "shell", inline: <<-SHELL
      sudo yum update
      sudo yum install -y java-1.8.0-openjdk-devel
      sudo rpm -ivh http://nginx.org/packages/centos/6/noarch/RPMS/nginx-release-centos-6-0.el6.ngx.noarch.rpm
      sudo yum install -y nginx
    SHELL
  end
end
