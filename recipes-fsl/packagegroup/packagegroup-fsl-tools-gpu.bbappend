# imx-gpu-sdk-surround-view requires 2d && 3d && (x11 || framebuffer)
SOC_TOOLS_GPU_IMXGPU2D          = ""
SOC_TOOLS_GPU_IMXGPU2D_imxgpu2d = " imx-gpu-sdk-surround-view"
SOC_TOOLS_GPU_append_imxgpu3d   = \
    "${@bb.utils.contains('DISTRO_FEATURES', 'wayland', '', \
        bb.utils.contains('DISTRO_FEATURES',     'x11', '${SOC_TOOLS_GPU_IMXGPU2D}', \
                                                        '${SOC_TOOLS_GPU_IMXGPU2D}', d), d)}"
SOC_TOOLS_GPU_append_imxgpu3d = " imx-gpu-sdk-tesselation-rle"
