version=$1

echo "###############params is:$version ###############"

if [ ! -n "$version" ] ;then
	#statements
	echo "------------please type params version context such as:[update_patch_20191227AM10]------------"
else

	echo "####################star to update ####################"

	#切换用户到resin
	if [ "resin" = "$USER" ];then
		echo "current user is resin, you may to do something."
	else
		echo "change opertion user to resin";
		sudo sh -c 'su resin'
	fi

	count=$(ps -ef |grep java |grep -v "grep" |wc -l)

	if [ $count -eq 0 ]; then
		echo "no server is running"
	else
		echo "###############update patch stop server start###############"
		#停服
		sh -c 'source /etc/profile;sh /ngbs/local/JmCash/bin/httpd.sh stop'
		echo "###############update patch stop server end  ###############"
	fi
	
	#删除旧包
	echo "##############start to delete old jar ##############"
	rm /ngbs/local/JmCash/lib/JmCash-* -rf
	echo "##############end   to delete old jar ##############"

	#解压端包
	echo "##############to xvf tar start##############"
	tar -xvf /tmp/$version.tar -C /ngbs/local/JmCash/lib/
	echo "##############to xvf tar end  ##############"

	count=$(ps -ef |grep java |grep -v "grep" |wc -l)

	echo "############running pid is:$count"

	if [ $count -eq 0 ]; then
		#启动服务
		sh -c 'source /etc/profile;sh /ngbs/local/JmCash/bin/httpd.sh start'
		echo "####################end to update ####################"
		echo "waiting 5s to show stdout.log"
		sleep 5
		#查看日志
		tail -f /ngbs/local/JmCash/log/stdout.log
	else
		echo "the server is running"
	fi
fi
