export PS1='\[\033[01;32m\]\u@$(hostname)\[\033[00m\]:\[\033[01;34m\]\w [$(mount | sed -n -e "s/^\/dev\/.* on \/ .*(\(r[w|o]\).*/\1/p")] \$\[\033[00m\] '
export LS_OPTIONS='--color=auto'
eval `dircolors`

. /etc/bash_completion
