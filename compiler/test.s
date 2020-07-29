	.text
	.file	"test.ll"
	.section	.rodata.cst8,"aM",@progbits,8
	.p2align	3               # -- Begin function main
.LCPI0_0:
	.quad	4620693217682128896     # double 8
	.text
	.globl	main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	$1083179008, 4(%rsp)    # imm = 0x40900000
	movl	$1080033280, (%rsp)     # imm = 0x40600000
	movsd	.LCPI0_0(%rip), %xmm0   # xmm0 = mem[0],zero
	movl	$.L.str_1, %edi
	movb	$1, %al
	callq	printf
	movss	4(%rsp), %xmm0          # xmm0 = mem[0],zero,zero,zero
	addss	(%rsp), %xmm0
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end0:
	.size	main, .Lfunc_end0-main
	.cfi_endproc
                                        # -- End function
	.type	.L.str_1,@object        # @.str_1
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str_1:
	.asciz	"%f\n"
	.size	.L.str_1, 4

	.section	".note.GNU-stack","",@progbits
