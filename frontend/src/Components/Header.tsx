import {
  Group,
  Button,
  Divider,
  Box,
  rem,
  Modal,
  Space,
  Container,
  Title,
  Tooltip
} from '@mantine/core';
import { useDisclosure } from '@mantine/hooks';
import {
  IconCheckbox,
} from '@tabler/icons-react';

export function Header() {
  const [opened, { open, close }] = useDisclosure(false);
  const iconStyle = { width: rem(12), height: rem(12) };

  return (
    <>
      <Container fluid>
        <Space h={'md'}></Space>
        <Box pb={20}>
            <Group grow >
                <Group >
                  <IconCheckbox size={40}/>
                  <Title order={2} c={'blue'}>Habit</Title><Title order={2}>Tracker</Title>
                </Group>
              <Group visibleFrom="sm" justify='flex-end' pr={20}>
                <Modal opened={opened} onClose={close} title="Log in" centered>
                  Modal content 
                </Modal> 
                  <Tooltip label="Log-in/sign-up functionality to be added in future versions">
                  <Button variant="default" onClick={open} disabled>Log in</Button>
                  </Tooltip>
                  <Tooltip label="Log-in/sign-up functionality to be added in future versions">
                  <Button disabled>Sign up</Button>
                  </Tooltip>
                </Group>
            </Group>
          <Space h={20}></Space>
          <Divider />
        </Box>
      </Container>
    </>
  );
}
